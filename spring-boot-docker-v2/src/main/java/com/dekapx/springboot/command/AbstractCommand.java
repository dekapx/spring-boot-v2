package com.dekapx.springboot.command;

import com.dekapx.springboot.domain.StatusEntity;
import com.dekapx.springboot.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractCommand {
    @Autowired
    private StatusRepository statusRepository;

    protected StatusEntity getStatus(final String statusType) {
        return statusRepository.findByStatus(statusType);
    }
}
