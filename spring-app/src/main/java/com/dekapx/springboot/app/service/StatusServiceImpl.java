package com.dekapx.springboot.app.service;

import com.dekapx.springboot.app.domain.Status;
import com.dekapx.springboot.app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.dekapx.springboot.app.util.MessageUtils.getNotNullOrEmptyMessage;
import static org.springframework.util.Assert.hasLength;
import static org.springframework.util.Assert.notNull;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class StatusServiceImpl implements StatusService {
    private StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(final StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status findByStatusKey(final String statusKey) {
        notNull(statusKey, getNotNullOrEmptyMessage("statusKey"));
        hasLength(statusKey, getNotNullOrEmptyMessage("statusKey"));
        return this.statusRepository.findByStatusKey(statusKey);
    }


}
