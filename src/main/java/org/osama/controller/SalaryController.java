package org.osama.controller;



import org.osama.model.Salary;
import org.osama.model.SalaryToEcxcel;
import org.osama.reportView.ExcelSalaryReport;
import org.osama.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/")
    public String logIn( Model model){
          return "editSalary";
    }

//    @RequestMapping("/main")
//    public String main( Model model){
//        model.addAttribute("salaries", salaryService.list());
//        servletContext.setAttribute("salaries",salaryService.list());
//        return "editSalary";
//    }
    @RequestMapping("/user")
    public String user( Model model){
        model.addAttribute("salaries", salaryService.list());
        servletContext.setAttribute("salaries",salaryService.list());
        return "editSalary";
    }
    @RequestMapping("/admin")
    public String admin( Model model){
        model.addAttribute("salaries", salaryService.list());
        servletContext.setAttribute("salaries",salaryService.list());
        return "editSalary";
    }

    //...........................................................................
//    @RequestMapping("/")
//    public String userForm(Locale locale, Model model) {
//        model.addAttribute("salaries", salaryService.list());
//        servletContext.setAttribute("salaries",salaryService.list());
//        return "editSalary";
//    }

    @ModelAttribute("salary")
    public Salary formBackingObject() {
        return new Salary();
    }

   @RequestMapping(value = "/addSalary" ,method = RequestMethod.GET)
    public ModelAndView addSalary(@ModelAttribute("salary") @Valid Salary salary, BindingResult result) {
       if (result.hasErrors()) {

           return new ModelAndView("form","salary",salary);
       }
       return new ModelAndView("form","salary",salary);
    }

    @RequestMapping(value = "/update/{id}" ,method = RequestMethod.GET)
    public ModelAndView updateSalary(@PathVariable("id") int id) {
        ModelAndView modelAndView=new ModelAndView("form");
        Salary salaryById = salaryService.findSalaryById(id);
        modelAndView.addObject("salary",salaryById);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.GET)
    public String deleteSalary(@PathVariable("id") int id, Principal principal) {
       salaryService.deleteSalary(id);
       if(principal.equals("osama")){
           return "redirect:/user";
       }
        return "redirect:/admin";
    }
    @PostMapping("/saveUpdateSalary")
    public String saveUpdateSalary(@ModelAttribute("salary") Salary salaryForm,Principal principal) {
        System.out.println(salaryForm.getId()+" "+salaryForm.getSequence()+"  "+salaryForm.getSequence()+" "+salaryForm.getBankSwiftCode());
        if(salaryForm.getId()==null||salaryForm.getId()==0){
            salaryService.save(salaryForm);
        }else {
            salaryService.updateSalary(salaryForm);
        }
        if(principal.equals("osama")){
            return "redirect:/user";
        }
        return "redirect:/admin";
    }
     @RequestMapping(value = "/download",method = RequestMethod.POST)
    public ModelAndView download(HttpServletRequest request ){
       // String type = request.getParameter("type");
        List<Salary> listSalary = (List<Salary>) servletContext.getAttribute("salaries");
        List<SalaryToEcxcel> list=new ArrayList<>();
        int i=0;
       for(Salary s:listSalary){
           SalaryToEcxcel salaryToEcxcel=new SalaryToEcxcel();
           salaryToEcxcel.setAmount(request.getParameter("amount"+i));
            System.out.println(request.getParameter("amount"+i)+"  "+s.getBankSwiftCode());
           salaryToEcxcel.setBankNumber(s.getBankNumber());
           salaryToEcxcel.setBankSwiftCode(s.getBankSwiftCode());
           salaryToEcxcel.setCodeTransfer(s.getCodeTransfer());
           salaryToEcxcel.setFullName(s.getFullName());
           salaryToEcxcel.setIcNumber(Integer.valueOf(s.getIcNumber()));
           salaryToEcxcel.setId(s.getId());
           salaryToEcxcel.setSequence(Integer.valueOf(s.getSequence()));
            list.add(salaryToEcxcel);
           i++;
       }
       servletContext.setAttribute("list",list);
        return new ModelAndView("download");
    }

    @RequestMapping("/downloadPage")
    public ModelAndView downloadPage(HttpServletRequest request){
        String type = request.getParameter("type");
        List<SalaryToEcxcel> list = (List<SalaryToEcxcel>) servletContext.getAttribute("list");

        if(type!=null&&type.equals("xlsx")){
            return new ModelAndView(new ExcelSalaryReport(),"salaryExcel",list);
        }
        return new ModelAndView("download","salaryExcel",list);
    }


}
