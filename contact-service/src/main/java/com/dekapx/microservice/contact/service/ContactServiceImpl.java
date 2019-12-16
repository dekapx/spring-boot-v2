package com.dekapx.microservice.contact.service;

import com.dekapx.microservice.contact.domain.Contact;
import com.dekapx.microservice.contact.dto.ContactDto;
import com.dekapx.microservice.contact.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service(ContactService.QUALIFIER)
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository repository;

    @Override
    public void save(final ContactDto contactDto) {
        log.info("contact save...");
    }

    @Override
    public Contact findById(Long id) {
        final Optional<Contact> contactOptional = repository.findById(id);
        log.info("Perform lookup for contact {}", contactOptional);
        return contactOptional.orElseThrow(() -> new ContactNotFoundException(id));
    }

    @Override
    public List<Contact> findAll() {
        log.info("Return all the contacts...");
        return repository.findAll();
    }
}
