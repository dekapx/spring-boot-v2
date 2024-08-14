package com.dekapx.apps.contact.service;

import com.dekapx.apps.contact.model.ContactModel;
import com.dekapx.apps.contact.specification.ContactSpecification;
import com.dekapx.apps.core.exception.ResourceNotFoundException;
import com.dekapx.apps.core.search.SearchCriteria;
import com.dekapx.apps.core.search.SearchOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ContactServiceIT {
    private static final String FIRST_NAME = "Test";
    private static final String LAST_NAME = "User";
    private static final String EMAIL = "testuser@google.com";
    private static final String MODIFIED_EMAIL = "testuser@outlook.com";
    private static final String PHONE = "+1 (123) 456 7890";

    @Autowired
    private ContactService contactService;

    @Test
    @DisplayName("ContactService CRUD")
    public void createUpdateAndDelete() {
        createAndVerify();
        updateAndVerify();
        cleanUp();
    }

    private void createAndVerify() {
        final ContactModel contact = this.contactService.save(contactSupplier.get());
        assertAll(
                () -> assertNotNull(contact),
                () -> assertEquals(FIRST_NAME, contact.getFirstName()),
                () -> assertEquals(LAST_NAME, contact.getLastName()),
                () -> assertEquals(EMAIL, contact.getEmail()),
                () -> assertEquals(PHONE, contact.getPhone())
        );

        assertThat(contact).isNotNull()
                .satisfies(c -> {
                    assertThat(c.getFirstName()).isEqualTo(FIRST_NAME);
                    assertThat(c.getLastName()).isEqualTo(LAST_NAME);
                    assertThat(c.getEmail()).isEqualTo(EMAIL);
                    assertThat(c.getPhone()).isEqualTo(PHONE);
                });
    }

    private void updateAndVerify() {
        final ContactModel contact = findContactBySpecification();
        contact.setEmail(MODIFIED_EMAIL);

        final ContactModel contactModified = this.contactService.update(contact.getId(), contact);
        assertAll(
                () -> assertNotNull(contactModified),
                () -> assertEquals(FIRST_NAME, contact.getFirstName()),
                () -> assertEquals(LAST_NAME, contact.getLastName()),
                () -> assertEquals(MODIFIED_EMAIL, contact.getEmail()),
                () -> assertEquals(PHONE, contact.getPhone())
        );
    }

    private void cleanUp() {
        final ContactModel contact = findContactBySpecification();
        this.contactService.delete(contact.getId());
    }

    private ContactModel findContactBySpecification() {
        final SearchCriteria searchCriteria = SearchCriteria.builder()
                .key("firstName")
                .operation(SearchOperation.EQUAL)
                .value(FIRST_NAME)
                .build();
        final ContactSpecification specification = new ContactSpecification();
        specification.addSearchCriteria(searchCriteria);
        return this.contactService.findBySpecification(specification);
    }

    @Test
    @DisplayName("Find Contact by ID Throw Exception")
    public void givenInvalidContactIdThrowException() {
        final Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            this.contactService.findById(1L);
        });
        assertAll(() -> assertEquals("Contact with ID [1] not found.", exception.getMessage()));
    }

    private Supplier<ContactModel> contactSupplier = () ->
            ContactModel.builder()
                    .firstName(FIRST_NAME)
                    .lastName(LAST_NAME)
                    .email(EMAIL)
                    .phone(PHONE)
                    .build();
}
