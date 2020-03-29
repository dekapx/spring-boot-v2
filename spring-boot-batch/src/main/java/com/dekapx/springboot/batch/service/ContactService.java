package com.dekapx.springboot.batch.service;

import com.dekapx.springboot.batch.model.Contact;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContactService {
    Contact save(Contact contact);
    List<Contact> findAll(Specification<Contact> specification);
}
