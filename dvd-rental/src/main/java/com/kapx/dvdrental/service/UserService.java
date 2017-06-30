package com.kapx.dvdrental.service;

import com.kapx.dvdrental.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto dto);

    void delete(String username);

    UserDto findByUserName(String username);

    List<UserDto> findAll();
}
