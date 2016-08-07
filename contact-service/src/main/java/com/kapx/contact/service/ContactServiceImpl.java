package com.kapx.contact.service;

import com.kapx.contact.domain.Contact;
import com.kapx.contact.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void save(final Contact contact) {
        contactRepository.save(contact);
        LOGGER.info("--- Contact save for ID {} ---", contact.getId());
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact find(final Long id) {
        return contactRepository.findOne(id);
    }

}
