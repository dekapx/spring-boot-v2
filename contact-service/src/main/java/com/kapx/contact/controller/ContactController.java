package com.kapx.contact.controller;

import com.kapx.contact.domain.Contact;
import com.kapx.contact.service.ContactService;
import com.kapx.contact.vo.ContactVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;


    @RequestMapping(value = "/save", method = GET)
    public void save() {
        final Contact contact = new Contact();
        contact.setFirstName("De");
        contact.setLastName("Kapx");
        contact.setPhone("123456789");
        contact.setEmail("dekapx@kapxinc.com");

        contactService.save(contact);
        LOGGER.info("--- Contact save request ---");
    }

    @RequestMapping(value = "/find/{id}", method = GET)
    public Contact find(@PathVariable final Long id) {
        LOGGER.info("--- getContact REST requestfor ID {} ---", id);
        return contactService.find(id);
    }

    @RequestMapping(value = "/findAll", method = GET)
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @RequestMapping(value = "/ping", method = GET)
    public String ping() {
        LOGGER.info("--- Contact Service REST Controller ping method invoked. ---");
        return "Contact Service REST Controller";
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
