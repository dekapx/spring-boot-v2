package com.dekapx.springboot.dao;

import com.dekapx.springboot.model.Employee;

public interface EmployeeDao {
    void save(Employee employee);
    Employee findOne(Long id);
}
