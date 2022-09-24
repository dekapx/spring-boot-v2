package com.dekapx.apps.contact.service;

import com.dekapx.apps.contact.domain.Contact;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContactService {
    Contact findById(Long id);

    List<Contact> findAllContacts();

    List<Contact> findBySpecification(final Specification<Contact> specification);
}
