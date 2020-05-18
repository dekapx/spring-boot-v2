package com.dekapx.springboot.completable;


import java.util.concurrent.CompletableFuture;

public interface EmployeeService {
    CompletableFuture<Employee> findOne(Long id);
}
