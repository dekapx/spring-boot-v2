package com.dekapx.springboot.service;

import com.dekapx.springboot.domain.ContactEntity;
import com.dekapx.springboot.dto.ContactDto;
import org.springframework.stereotype.Component;

@Component
public class ContactServiceHelperImpl implements ContactServiceHelper {
    @Override
    public ContactDto toContactDto(final ContactEntity entity) {
        return ContactDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .status(entity.getStatus().getStatus())
                .modifiedBy(entity.getModifiedBy())
                .build();
    }

    @Override
    public ContactEntity toContactEntity(final ContactDto dto) {
        final ContactEntity entity = new ContactEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setModifiedBy(dto.getModifiedBy());
        return entity;
    }
}
