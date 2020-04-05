package com.dekapx.springboot.batch.service;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public Contact findByFirstName(String firstName) {
        log.info("-------------- findByFirstName({}) --------------", firstName);
        return this.contactRepository.findByFirstName(firstName);
    }

    @Override
    public List<Contact> findAll() {
        return this.contactRepository.findAll();
    }

    @Override
    public List<Contact> findByStatusKey(String statusKey) {
        log.info("-------------- findByStatusKey({}) --------------", statusKey);
        return this.contactRepository.findByStatusKey(statusKey);
    }

    @Override
    public List<Contact> findBySpecification(final Specification<Contact> specification) {
        return this.contactRepository.findAll(specification);
    }

    @Override
    public void delete(Contact contact) {
        this.contactRepository.delete(contact);
    }
}
