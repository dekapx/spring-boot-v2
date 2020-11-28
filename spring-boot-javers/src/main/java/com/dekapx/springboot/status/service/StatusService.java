package com.dekapx.springboot.status.service;

import com.dekapx.springboot.status.domain.Status;

public interface StatusService {
    Status findByStatusKey(final String statusKey);
}
