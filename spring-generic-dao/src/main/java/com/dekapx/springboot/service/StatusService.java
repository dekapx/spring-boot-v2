package com.dekapx.springboot.service;

import com.dekapx.springboot.model.Status;

public interface StatusService {
    Status findOne(final Long id);
}
