package com.dekapx.apps.contact.service;

import com.dekapx.apps.contact.domain.Contact;

public interface ContactService {
    Contact findById(Long id);

    Contact save(Contact contact);
}
