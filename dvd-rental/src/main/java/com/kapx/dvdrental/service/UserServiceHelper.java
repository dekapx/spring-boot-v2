package com.kapx.dvdrental.service;

import com.kapx.dvdrental.domain.UserEntity;
import com.kapx.dvdrental.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class UserServiceHelper {
    public Function<UserEntity, UserDto> userEntityToDtoCopyFunction = (final UserEntity entity) -> {
        final UserDto userDto = UserDto.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
        return userDto;
    };

    public Function<UserDto, UserEntity> userDtoToEntityCopyFunction = (final UserDto dto) -> {
        final UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setCreateDate(new Date());
        return entity;
    };
}
