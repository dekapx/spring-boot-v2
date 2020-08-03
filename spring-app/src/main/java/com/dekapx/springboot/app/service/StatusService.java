package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Status;

public interface StatusService {
    Status findByStatusKey(String statusKey);
}
