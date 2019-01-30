package org.osama.dao;

import org.osama.model.Salary;

import java.util.List;

public interface SalaryDao {
    void save(Salary salary);
    void updateSalary(Salary salary);
    void deleteSalary(int id);
    Salary findSalaryById(int id);
    List<Salary> list();

}
