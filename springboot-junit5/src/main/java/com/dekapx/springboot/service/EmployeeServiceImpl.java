package com.dekapx.springboot.service;

import com.dekapx.springboot.dao.EmployeeDao;
import com.dekapx.springboot.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(Employee employee) {
        log.info("save employee...");
        this.employeeDao.save(employee);
    }

    @Override
    public Employee findOne(Long id) {
        log.info("find by id [{}]...", id);
        return employeeDao.findOne(id);
    }
}
