package com.dekapx.springboot.controller;

import com.dekapx.springboot.model.Employee;
import com.dekapx.springboot.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        log.info("Perform lookup for Employee by ID [{}]", id);
        final Employee employee = this.employeeService.findOne(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public ResponseEntity<Employee> handleException(final Exception e) {
        return new ResponseEntity<>(new Employee(), HttpStatus.BAD_REQUEST);

    }
}
