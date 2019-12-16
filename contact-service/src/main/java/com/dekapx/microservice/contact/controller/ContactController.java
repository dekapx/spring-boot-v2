package com.dekapx.microservice.contact.controller;

import com.dekapx.microservice.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    @Qualifier(ContactService.QUALIFIER)
    private ContactService contactService;
}
