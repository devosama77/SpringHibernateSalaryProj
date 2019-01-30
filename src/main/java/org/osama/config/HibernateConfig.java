package org.osama.config;



import org.osama.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableWebSecurity
@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("org.osama")})
public class HibernateConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ApplicationContext context;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factoryBean.setAnnotatedClasses(Salary.class);
		//factoryBean.setAnnotatedClasses(Account.class);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("osama").password("123").roles("USER")
				.and()
				.withUser("admin").password("pass123").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
				.and()
				.authorizeRequests().antMatchers("/user**").hasRole("USER")
				.and()
				.authorizeRequests().antMatchers("/**").hasRole("USER")
				.and()
				.authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
				.and()
				.formLogin()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

}
