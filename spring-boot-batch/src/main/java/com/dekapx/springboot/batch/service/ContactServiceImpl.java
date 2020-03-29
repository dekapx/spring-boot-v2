package com.dekapx.springboot.batch.service;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> findAll(Specification<Contact> specification) {
        return contactRepository.findAll(specification);
    }
}
