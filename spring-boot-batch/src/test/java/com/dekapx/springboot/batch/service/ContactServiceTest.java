package com.dekapx.springboot.batch.service;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactServiceTest {
    @Autowired
    private StatusService statusService;

    @Autowired
    private ContactService contactService;

    @Test
    public void save() {
        Contact contact = contactService.save(createContact());
        assertThat(contact).isNotNull();
        assertThat(contact.getFirstName()).isEqualTo("De");
        assertThat(contact.getLastName()).isEqualTo("Kapx");
        assertThat(contact.getEmail()).isEqualTo("dekapx@kapxinc.com");
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
        return statusService.findByStatusName("AUTHORISED");
    }
}
