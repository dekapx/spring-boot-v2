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
        CompletableFuture<Employee> employee = employeeService.findOne(1L);
        CompletableFuture<Address> address = addressService.findOne(1L);
        CompletableFuture.allOf(employee,address).join();

        return AggregatedResponse.builder()
                .employee(employee.get())
                .address(address.get())
                .build();
    }
}
