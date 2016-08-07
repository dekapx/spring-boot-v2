package com.kapx.contact.service;

import com.kapx.contact.domain.Contact;

import java.util.List;

public interface ContactService {
    void save(Contact contact);

    List<Contact> findAll();

    Contact find(Long id);
}
