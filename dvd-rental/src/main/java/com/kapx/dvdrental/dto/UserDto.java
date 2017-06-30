package com.kapx.dvdrental.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Builder
public class UserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
