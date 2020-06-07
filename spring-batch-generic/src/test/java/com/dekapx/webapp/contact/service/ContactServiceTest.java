package com.dekapx.webapp.contact.service;

import com.dekapx.webapp.contact.model.Contact;
import com.dekapx.webapp.contact.model.Status;
import com.dekapx.webapp.contact.repository.ContactSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactServiceTest {
    @Autowired
    private StatusService statusService;

    @Autowired
    private ContactService contactService;

    @Test
    public void createAndFindContact() {
        contactService.save(createContact());
        Specification firstNameSpec = ContactSpecification.compareByFirstName("De");
        List<Contact> contacts = contactService.findBySpecification(firstNameSpec);
        Contact contact = contacts.iterator().next();
        assertThat(contact).isNotNull();
        assertThat(contact.getFirstName()).isEqualTo("De");
        assertThat(contact.getLastName()).isEqualTo("Kapx");
        assertThat(contact.getEmail()).isEqualTo("dekapx@kapxinc.com");
        assertThat(contact.getPhone()).isEqualTo("+353 01 234 5678");
        contactService.delete(contact);
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
        return statusService.findByStatusKey("STATUS.1");
    }
}
