package com.dekapx.springboot.completable;

import java.util.concurrent.CompletableFuture;

public interface AddressService {
    CompletableFuture<Address> findOne(Long id);
}
