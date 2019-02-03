package com.dekapx.springboot.contact.repository;

import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.contact.domain.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactRepositoryTest {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Test
    public void performContactCrudOperations() {
        Long id = verifyCreate();
        verifyFind(id);
        verifyDelete(id);
    }

    private Long verifyCreate() {
        Contact contact = new Contact();
        contact.setFirstName("Test");
        contact.setLastName("Contact");
        contact.setEmail("test@gmail.com");
        contact.setPhone("0123456789");

        final Status status = getStatus();
        contact.setStatus(status);
        contact = contactRepository.save(contact);

        Long id = contact.getId();
        assertNotNull(id);
        return id;
    }

    private void verifyFind(final Long id) {
        Optional<Contact> optionalEntity = contactRepository.findById(id);
        Contact contact = optionalEntity.orElseThrow(() -> new ContactNotFoundException(String.valueOf(id)));
        assertNotNull(contact);
        assertEquals(id, contact.getId());
    }

    private void verifyDelete(final Long id) {
        Optional<Contact> optionalEntity = contactRepository.findById(id);
        Contact contact = optionalEntity.orElseThrow(() -> new ContactNotFoundException(String.valueOf(id)));
        contactRepository.delete(contact);
    }

    private Status getStatus() {
        return statusRepository.findByStatus("PENDING_AUTHORISED");
    }
}
