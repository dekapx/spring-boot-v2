package com.dekapx.springboot.service;

import com.dekapx.springboot.model.Contact;
import com.dekapx.springboot.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactServiceTest {
    @Autowired
    private ContactService contactService;

    @Autowired
    private StatusService statusService;

    @Test
    public void persistContact() {
        Contact contact = createContact();
        contactService.create(contact);
        assertThat(true).isTrue();
    }


    private Contact createContact() {
        Contact contact = new Contact();
        contact.setFirstName("De");
        contact.setLastName("Kapx");
        contact.setEmail("dekapx@kapxinc.com");
        contact.setPhone("+353 01 234 5678");
        contact.setStatus(getAuthorizedStatus());
        return contact;
    }

    private Status getAuthorizedStatus() {
        return statusService.findOne(1L);
    }
}
