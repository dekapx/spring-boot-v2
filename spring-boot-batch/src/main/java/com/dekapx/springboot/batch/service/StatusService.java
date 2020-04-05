package com.dekapx.springboot.batch.service;

import com.dekapx.springboot.batch.model.Status;

public interface StatusService {
    Status findByStatusKey(String statusKey);
}
