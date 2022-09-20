package com.dekapx.apps.contact.service;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.repository.ContactRepository;
import com.dekapx.apps.contact.repository.StatusRepository;
import com.dekapx.apps.core.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Contact findById(final Long id) {
        var contactOptional = this.contactRepository.findById(id);
        return contactOptional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [%d] not found.", id)));
    }

    @Override
    public List<Contact> findAllContacts() {
        final List<Contact> contacts = new ArrayList<>();
        this.contactRepository.findAll().forEach(c -> contacts.add(c));
        return contacts;
    }

    @Override
    public List<Contact> findBySpecification(final Specification<Contact> specification) {
        return null;
    }
}
