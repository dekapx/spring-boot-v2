package com.dekapx.microservice.contact.service;

import com.dekapx.microservice.contact.domain.Contact;
import com.dekapx.microservice.contact.dto.ContactDto;

import java.util.List;

public interface ContactService {
    final String QUALIFIER = "contactService";

    void save(ContactDto contactDto);

    Contact findById(Long id);

    List<Contact> findAll();
}
