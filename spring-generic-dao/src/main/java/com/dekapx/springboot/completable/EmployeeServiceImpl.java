package com.dekapx.springboot.completable;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public CompletableFuture<Employee> findOne(Long id) {
        Employee employee = Employee.builder()
                .id(1L)
                .firstName("De")
                .lastName("Kapx")
                .build();
        return CompletableFuture.completedFuture(employee);
    }
}
