package com.dekapx.springboot.dao;

import com.dekapx.springboot.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void save(Employee employee) {
        log.info("save employee...");
    }

    @Override
    public Employee findOne(Long id) {
        log.info("find by id [{}]...", id);
        return Employee.builder()
                .id(1L)
                .name("Dummy")
                .build();
    }
}
