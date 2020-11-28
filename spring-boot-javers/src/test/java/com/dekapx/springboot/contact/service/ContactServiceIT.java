package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.status.service.StatusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.dekapx.springboot.core.common.CommonConstants.STATUS_AUTHORISED_KEY;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactServiceIT {
    @Autowired
    private ContactService contactService;
    @Autowired
    private StatusService statusService;

    @Test
    public void createNewContact() {
        Contact contact = saveContact();
        updateContactEmail(contact.getId());
        updateContactPhone(contact.getId());
        deleteContact(contact.getId());
    }

    private Contact saveContact() {
        Contact contact = this.contactService.save(buildContact());
        assertThat(contact.getId()).isNotNull();
        assertThat(contact.getEmail()).isEqualTo("test@mydomain.com");
        assertThat(contact.getPhone()).isEqualTo("+1 123 456 7890");
        return contact;
    }

    private void updateContactEmail(Long id) {
        Contact contact = this.contactService.findById(id);
        contact.setEmail("test@mydomain.ie");
        contact = this.contactService.save(contact);
        assertThat(contact.getEmail()).isEqualTo("test@mydomain.ie");
    }

    private void updateContactPhone(Long id) {
        Contact contact = this.contactService.findById(id);
        contact.setPhone("+353 89 999 8888");
        contact = this.contactService.save(contact);
        assertThat(contact.getPhone()).isEqualTo("+353 89 999 8888");
    }

    private void deleteContact(Long id) {
        this.contactService.deleteById(id);
    }

    private Contact buildContact() {
        final Contact contact = new Contact();
        contact.setFirstName("Test");
        contact.setLastName("User");
        contact.setEmail("test@mydomain.com");
        contact.setPhone("+1 123 456 7890");
        contact.setStatus(statusService.findByStatusKey(STATUS_AUTHORISED_KEY));
        return contact;
    }
}
