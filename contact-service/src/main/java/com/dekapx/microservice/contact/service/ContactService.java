package com.dekapx.microservice.contact.service;

import com.dekapx.microservice.contact.domain.Contact;

import java.util.List;

public interface ContactService {
    void save(Contact contact);

    void update(Contact contact);

    Contact findById(Long id);

    List<Contact> findAll();
}
