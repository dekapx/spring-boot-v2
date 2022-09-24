package com.dekapx.apps.contact.service;

import com.dekapx.apps.contact.domain.Contact;

import java.util.List;

public interface ContactService {
    Contact findById(Long id);

    List<Contact> findAllContacts();
}
