package com.dekapx.springboot.service;

import com.dekapx.springboot.dto.ContactDto;

public interface ContactService {
    ContactDto save(ContactDto dto);
    ContactDto authorize(Long id);
}
