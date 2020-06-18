package com.dekapx.springboot.service;

import com.dekapx.springboot.model.Employee;

public interface EmployeeService {
    void save(Employee employee);
    Employee findOne(Long id);
}
