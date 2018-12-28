package com.dekapx.springboot.service;

import com.dekapx.springboot.domain.ContactEntity;
import com.dekapx.springboot.domain.StatusEntity;
import com.dekapx.springboot.dto.ContactDto;
import com.dekapx.springboot.repository.ContactRepository;
import com.dekapx.springboot.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER  = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ContactServiceHelper helper;

    @Override
    public void save(final ContactDto dto) {
        final ContactEntity entity = helper.toContactEntity(dto);
        final StatusEntity status = statusRepository.findByStatus(dto.getStatus());
        entity.setStatus(status);
        contactRepository.save(entity);
        LOGGER.info("New contact created...");
    }
}
