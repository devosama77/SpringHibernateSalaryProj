package org.osama.dao;

import org.hibernate.SessionFactory;
import org.osama.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SalaryDaoImp implements SalaryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Salary salary) {

        sessionFactory.getCurrentSession().save(salary);
    }

    @Override
    public void updateSalary(Salary salary) {
        sessionFactory.getCurrentSession().saveOrUpdate(salary);

    }

    @Override
    public void deleteSalary(int id) {
        Salary salary = sessionFactory.getCurrentSession().get(Salary.class, id);
        sessionFactory.getCurrentSession().delete(salary);
    }

    @Override
    public Salary findSalaryById(int id) {
        Salary salary = sessionFactory.getCurrentSession().get(Salary.class, id);
        return salary;
    }


    @Override
    public List<Salary> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Salary> query = sessionFactory.getCurrentSession().createQuery("from Salary");
        return query.getResultList();
    }
}
