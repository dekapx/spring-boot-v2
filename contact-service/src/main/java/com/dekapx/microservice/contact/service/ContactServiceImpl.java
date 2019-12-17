package com.dekapx.microservice.contact.service;

import com.dekapx.microservice.contact.domain.Contact;
import com.dekapx.microservice.contact.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository repository;

    @Override
    public void save(final Contact contact) {
        log.info("Create new Contact...");
        this.repository.save(contact);
    }

    @Override
    public void update(Contact newContact) {
        log.info("Update Contact information...");
        final Optional<Contact> contactOptional = this.repository.findById(newContact.getId());
        final Contact contact = contactOptional.orElseThrow(() -> new ContactNotFoundException(newContact.getId()));
        contact.setFirstName(newContact.getFirstName());
        contact.setLastName(newContact.getLastName());
        contact.setEmail(newContact.getEmail());

        this.repository.save(contact);
    }

    @Override
    public Contact findById(Long id) {
        final Optional<Contact> contactOptional = this.repository.findById(id);
        log.info("Perform lookup for contact {}", contactOptional);
        return contactOptional.orElseThrow(() -> new ContactNotFoundException(id));
    }

    @Override
    public List<Contact> findAll() {
        log.info("Return all the contacts...");
        return this.repository.findAll();
    }
}
