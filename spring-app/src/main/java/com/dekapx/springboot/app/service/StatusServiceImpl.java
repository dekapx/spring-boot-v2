package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Status;
import com.dekapx.springboot.app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.dekapx.springboot.app.util.MessageUtils.getNotNullOrEmptyMessage;
import static org.springframework.util.Assert.hasLength;
import static org.springframework.util.Assert.notNull;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StatusServiceImpl implements StatusService {
    private StatusRepository repository;

    @Autowired
    public StatusServiceImpl(final StatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public Status findByStatusKey(final String statusKey) {
        notNull(statusKey, getNotNullOrEmptyMessage("statusKey"));
        hasLength(statusKey, getNotNullOrEmptyMessage("statusKey"));
        return this.repository.findByStatusKey(statusKey);
    }
}
