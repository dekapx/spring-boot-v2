package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.domain.Contact;

public interface ContactService {
    Contact save (Contact contact);
    Contact findById(Long id);
    void deleteById(Long id);
}
