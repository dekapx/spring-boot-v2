package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.contact.dto.ContactDto;
import com.dekapx.springboot.contact.repository.ContactRepository;
import com.dekapx.springboot.core.convertor.Convertor;
import com.dekapx.springboot.core.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository repository;
    private Convertor<Contact, ContactDto> convertor;

    @Autowired
    public ContactServiceImpl(final ContactRepository repository, final Convertor<Contact, ContactDto> convertor) {
        this.repository = repository;
        this.convertor = convertor;
    }

    @Override
    public ContactDto save(final ContactDto dto) {
        final Contact contact = convertor.toEntity(dto);
        log.info("Persist new Contact...");
        return convertor.toDto(this.repository.save(contact));
    }

    @Override
    public ContactDto update(final ContactDto contactDto) {
        log.info("Find Contact by id [{}]...", contactDto.getId());
        final Optional<Contact> optional = this.repository.findById(contactDto.getId());
        final Contact contact = optional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [{}] not found...", contactDto.getId())));
        this.convertor.copyAttributes(contact, contactDto);
        return convertor.toDto(this.repository.save(contact));
    }

    @Override
    public ContactDto findById(final Long id) {
        log.info("Find Contact by id [{}]...", id);
        final Optional<Contact> optional = this.repository.findById(id);
        final Contact contact = optional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [{}] not found...", id)));
        return convertor.toDto(contact);
    }

    @Override
    public void delete(final Long id) {
        final Optional<Contact> optional = this.repository.findById(id);
        log.info("Delete Contact by id [{}]...", id);
        optional.ifPresent(c -> this.repository.delete(c));
    }
}
