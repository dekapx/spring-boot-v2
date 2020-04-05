package com.dekapx.springboot.batch.service;

import com.dekapx.springboot.batch.model.Status;
import com.dekapx.springboot.batch.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status findByStatusKey(String statusKey) {
        return this.statusRepository.findByStatusKey(statusKey);
    }
}
