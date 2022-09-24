package com.dekapx.apps.contact.repository;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.domain.Status;
import com.dekapx.apps.contact.specification.ContactSpecification;
import com.dekapx.apps.core.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactRepositoryITest {
    private static final String FIRST_NAME = "De";
    private static final String LAST_NAME = "Kapx";
    private static final String EMAIL = "dejango@google.com";
    private static final String PHONE = "+1 (123) 456 7890";

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private StatusRepository statusRepository;

    @BeforeEach
    public void setup() {
    }

    @Disabled
    @Test
    public void findBySpecification() {
        Specification specificationFirstName = ContactSpecification.getContactByFirstName("De");
        Specification specificationLastName = ContactSpecification.getContactByLastName("Kapx");
        Specification specificationStatus = ContactSpecification.getContactByStatus(5L);

        List<Contact> contacts = this.contactRepository.findAll(specificationFirstName.and(specificationLastName).and(specificationStatus));
        assertThat(contacts).isNotNull().isNotEmpty();
    }

    @Disabled
    @Test
    @DisplayName("ContactRepository CRUD")
    public void createUpdateAndDelete() {
        createAndVerify();
    }

    private void createAndVerify() {
        final var contact = this.contactRepository.save(contactSupplier.get());
        assertAll(
                () -> assertNotNull(contact),
                () -> assertEquals(FIRST_NAME, contact.getFirstName()),
                () -> assertEquals(LAST_NAME, contact.getLastName()),
                () -> assertEquals(EMAIL, contact.getEmail()),
                () -> assertEquals(PHONE, contact.getPhone())
        );
    }

    private Supplier<Contact> contactSupplier = () -> {
        final var contact = new Contact();
        contact.setFirstName(FIRST_NAME);
        contact.setLastName(LAST_NAME);
        contact.setEmail(EMAIL);
        contact.setPhone(PHONE);
        contact.setStatus(getStatus());
        return contact;
    };

    private Status getStatus() {
        Optional<Status> statusOptional = this.statusRepository.findById(5L);
        return statusOptional.orElseThrow(()
                -> new ResourceNotFoundException("Status Not Found"));
    }

}
