package com.dekapx.apps.contact.repository;

import com.dekapx.apps.contact.domain.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ContactRepositoryITest {
    private static final String FIRST_NAME = "Test";
    private static final String LAST_NAME = "User";
    private static final String EMAIL = "testuser@google.com";
    private static final String PHONE = "+1 (123) 456 7890";

    @Autowired
    private ContactRepository repository;

    @BeforeEach
    public void setup() {
    }

    @Test
    @DisplayName("ContactRepository CRUD")
    public void createUpdateAndDelete() {
        createAndVerify();
    }

    private void createAndVerify() {
        final var contact = this.repository.save(contactSupplier.get());
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
        return contact;
    };
}
