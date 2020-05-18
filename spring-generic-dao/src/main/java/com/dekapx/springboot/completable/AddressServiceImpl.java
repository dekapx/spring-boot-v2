package com.dekapx.springboot.completable;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public CompletableFuture<Address> findOne(Long id) {
        Address address = Address.builder()
                .houseNo("1830")
                .street("Gateway Drive")
                .city("San Mateo")
                .county("CA")
                .build();
        return CompletableFuture.completedFuture(address);
    }
}
