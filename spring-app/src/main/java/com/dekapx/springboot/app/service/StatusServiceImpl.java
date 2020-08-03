package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Status;
import com.dekapx.springboot.app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.springframework.util.Assert.hasLength;
import static org.springframework.util.Assert.notNull;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status findByStatusKey(final String statusKey) {
        notNull(statusKey, "statusKey must not be null or empty.");
        hasLength(statusKey, "statusKey must not be null or empty.");
        return this.statusRepository.findByStatusKey(statusKey);
    }
}
