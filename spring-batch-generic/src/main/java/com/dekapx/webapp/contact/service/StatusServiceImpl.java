package com.dekapx.webapp.contact.service;

import com.dekapx.webapp.contact.model.Status;
import com.dekapx.webapp.contact.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status findByStatusKey(final String statusKey) {
        return this.statusRepository.findByStatusKey(statusKey);
    }
}
