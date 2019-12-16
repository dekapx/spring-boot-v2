package com.dekapx.microservice.contact.controller;

import com.dekapx.microservice.contact.domain.Contact;
import com.dekapx.microservice.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    @Qualifier(ContactService.QUALIFIER)
    private ContactService contactService;

    @GetMapping(value = "/contact/{id}", produces = "application/json")
    public Contact findById(@PathVariable Long id) {
        log.info("Perform lookup for contact by ID {}", id);
        return contactService.findById(id);
    }

    @GetMapping(value = "/contacts", produces = "application/json")
    public List<Contact> findAll() {
        log.info("Return all the contacts...");
        return contactService.findAll();
    }
}
