package com.dekapx.microservice.contact.controller;

import com.dekapx.microservice.contact.domain.Contact;
import com.dekapx.microservice.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping(value = "/contact/create", consumes = "application/json")
    public void save(@RequestBody Contact contact) {
        contactService.save(contact);
    }

    @PutMapping(value = "/contact/update", consumes = "application/json")
    public void update(@RequestBody Contact contact) {
        contactService.update(contact);
    }

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
