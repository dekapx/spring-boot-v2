package com.dekapx.springboot.batch.service;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.model.Status;
import com.dekapx.springboot.batch.specification.ContactSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactServiceTest {
    @Autowired
    private StatusService statusService;

    @Autowired
    private ContactService contactService;

    @Test
    public void saveAndFind() {
        contactService.save(createContact());
        Specification firstNameSpec = ContactSpecification.compareFirstName("De");
        List<Contact> contacts = contactService.findAll(firstNameSpec);
        assertThat(contacts).isNotNull().isNotEmpty().hasSize(1);
        Contact contact = contacts.iterator().next();
        assertThat(contact).isNotNull();
        assertThat(contact.getFirstName()).isEqualTo("De");
        assertThat(contact.getLastName()).isEqualTo("Kapx");
        assertThat(contact.getEmail()).isEqualTo("dekapx@kapxinc.com");
    }

    @Test
    public void populateData() {
        IntStream.range(1, 25).forEach(i -> consumer.accept(i));
    }

    IntConsumer consumer = (i) -> {
        Contact contact = new Contact();
        contact.setFirstName("Test " + i);
        contact.setLastName("User");
        contact.setEmail("testUser" + i + "@demo.com");
        contact.setPhone("+353 01 234 5678");
        contact.setStatus(getAuthorizedStatus());
        contactService.save(contact);
    };

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
