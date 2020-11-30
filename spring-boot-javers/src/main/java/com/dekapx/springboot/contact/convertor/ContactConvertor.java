package com.dekapx.springboot.contact.convertor;

import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.contact.dto.ContactDto;
import com.dekapx.springboot.core.convertor.Convertor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ContactConvertor implements Convertor<Contact, ContactDto> {
    @Override
    public Contact toEntity(final ContactDto dto) {
        final Contact contact = new Contact();
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
        return contact;
    }

    @Override
    public ContactDto toDto(final Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }

    @Override
    public void copyAttributes(final Contact contact, final ContactDto dto) {
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
    }
}
