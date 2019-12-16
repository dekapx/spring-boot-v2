package com.dekapx.microservice.contact.service;

import com.dekapx.microservice.contact.dto.ContactDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service(ContactService.QUALIFIER)
public class ContactServiceImpl implements ContactService {

    @Override
    public void save(final ContactDto contactDto) {
        log.info("contact save...");
    }
}
