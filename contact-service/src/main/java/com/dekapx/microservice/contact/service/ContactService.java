package com.dekapx.microservice.contact.service;

import com.dekapx.microservice.contact.dto.ContactDto;

public interface ContactService {
    final String QUALIFIER = "contactService";

    void save(ContactDto contactDto);
}
