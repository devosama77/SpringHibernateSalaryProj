package org.osama.service;



import org.osama.model.Salary;

import java.util.List;

public interface SalaryService {
    void save(Salary salary);
    void updateSalary(Salary salary);
    void deleteSalary(int id);
    Salary findSalaryById(int id);
    List<Salary> list();
}
