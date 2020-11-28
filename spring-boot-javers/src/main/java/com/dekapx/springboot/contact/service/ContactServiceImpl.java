package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.contact.repository.ContactRepository;
import com.dekapx.springboot.core.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository repository;

    @Autowired
    public ContactServiceImpl(final ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact save(final Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact findById(final Long id) {
        final Optional<Contact> optional = repository.findById(id);

        return optional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [{}] not found...", id)));
    }
}
