package com.dekapx.springboot.service;

import com.dekapx.springboot.domain.ContactEntity;
import com.dekapx.springboot.dto.ContactDto;

public interface ContactServiceHelper {

    ContactDto toContactDto(ContactEntity entity);

    ContactEntity toContactEntity(ContactDto dto);
}
