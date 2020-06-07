package com.dekapx.webapp.contact.service;

import com.dekapx.webapp.contact.model.Contact;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContactService {
    Contact save(Contact contact);
    Contact findByFirstName(String firstName);
    List<Contact> findAll();
    List<Contact> findByStatusKey(String statusKey);
    List<Contact> findBySpecification(Specification<Contact> specification);
    void delete(Contact contact);
    void deleteAll();
}
