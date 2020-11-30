package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.dto.ContactDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactServiceIT {
    @Autowired
    private ContactService contactService;

    @Test
    public void createNewContact() {
        ContactDto dto = saveContact();
        updateContactEmail(dto);
        updateContactPhone(dto);
//        deleteContact(dto.getId());
    }

    private ContactDto saveContact() {
        ContactDto dto = this.contactService.save(buildContactDto());
        assertThat(dto.getId()).isNotNull();
        assertThat(dto.getEmail()).isEqualTo("test@mydomain.com");
        assertThat(dto.getPhone()).isEqualTo("+1 123 456 7890");
        return dto;
    }

    private void updateContactEmail(ContactDto dto) {
        dto.setEmail("test@mydomain.ie");
        dto = this.contactService.update(dto);
        assertThat(dto.getEmail()).isEqualTo("test@mydomain.ie");
    }

    private void updateContactPhone(ContactDto dto) {
        dto.setPhone("+353 89 999 8888");
        dto = this.contactService.update(dto);
        assertThat(dto.getPhone()).isEqualTo("+353 89 999 8888");
    }

    private void deleteContact(Long id) {
        this.contactService.delete(id);
    }

    private ContactDto buildContactDto() {
        return ContactDto.builder()
                .firstName("Test")
                .lastName("User")
                .email("test@mydomain.com")
                .phone("+1 123 456 7890")
                .build();
    }
}
