package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Status;
import com.dekapx.springboot.app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StatusServiceImpl extends AbstractService implements StatusService {
    private StatusRepository repository;

    @Autowired
    public StatusServiceImpl(final StatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public Status findByStatusKey(final String statusKey) {
        performNullAndEmptyStringValidation("statusKey", statusKey);
        return this.repository.findByStatusKey(statusKey);
    }
}
