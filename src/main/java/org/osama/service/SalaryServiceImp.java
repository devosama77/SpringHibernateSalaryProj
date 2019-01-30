package org.osama.service;


import org.osama.dao.SalaryDao;
import org.osama.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaryServiceImp implements SalaryService {

    @Autowired
    private SalaryDao salaryDao;

    @Transactional
    public void save(Salary salary) {
        salaryDao.save(salary);
    }

    @Transactional
    public void updateSalary(Salary salary) {
        salaryDao.updateSalary(salary);
    }

    @Transactional
    public void deleteSalary(int id) {
            salaryDao.deleteSalary(id);
    }

    @Transactional
    public Salary findSalaryById(int id) {
        Salary salaryById = salaryDao.findSalaryById(id);
        return salaryById;
    }

    @Transactional(readOnly = true)
    public List<Salary> list() {
        return salaryDao.list();
    }
}
