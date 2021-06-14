package com.dekapx.apps.contact.service;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.repository.ContactRepository;
import com.dekapx.apps.core.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository repository;

    @Override
    public Contact findById(final Long id) {
        var contactOptional = this.repository.findById(id);
        return contactOptional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [%d] not found.", id)));
    }

    @Override
    public List<Contact> findAllContacts() {
        final List<Contact> contacts = new ArrayList<>();
        this.repository.findAll().forEach(c -> contacts.add(c));
        return contacts;
    }

}
