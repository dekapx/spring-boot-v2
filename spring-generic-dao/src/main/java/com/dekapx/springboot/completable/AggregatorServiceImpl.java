package com.dekapx.springboot.completable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AggregatorServiceImpl implements AggregatorService {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @Override
    public AggregatedResponse aggregate() throws ExecutionException, InterruptedException {
        CompletableFuture<Employee> employeeCompletableFuture = employeeService.findOne(1L);
        CompletableFuture<Address> addressCompletableFuture = addressService.findOne(1L);
        CompletableFuture.allOf(employeeCompletableFuture, addressCompletableFuture).join();

        return AggregatedResponse.builder()
                .employee(employeeCompletableFuture.get())
                .address(addressCompletableFuture.get())
                .build();
    }
}
