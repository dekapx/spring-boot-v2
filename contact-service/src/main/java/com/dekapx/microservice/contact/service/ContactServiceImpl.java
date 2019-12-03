package com.dekapx.microservice.contact.service;

import com.dekapx.microservice.contact.dto.ContactDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(ContactService.QUALIFIER)
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Override
    public void save(final ContactDto contactDto) {
        LOGGER.info("contact save...");
    }
}
