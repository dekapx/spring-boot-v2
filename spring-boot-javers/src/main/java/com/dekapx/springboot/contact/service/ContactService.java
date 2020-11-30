package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.dto.ContactDto;

public interface ContactService {
    ContactDto save (ContactDto contactDto);

    ContactDto update (ContactDto contactDto);

    ContactDto findById(Long id);

    void delete(Long id);
}
