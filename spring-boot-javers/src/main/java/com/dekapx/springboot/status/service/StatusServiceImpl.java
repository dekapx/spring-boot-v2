package com.dekapx.springboot.status.service;

import com.dekapx.springboot.status.domain.Status;
import com.dekapx.springboot.status.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    private StatusRepository repository;

    @Autowired
    public StatusServiceImpl(final StatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public Status findByStatusKey(final String statusKey) {
        return this.repository.findByStatusKey(statusKey);
    }
}
