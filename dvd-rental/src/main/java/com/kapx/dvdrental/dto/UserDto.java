package com.kapx.dvdrental.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private Date createDate;
    private Timestamp lastUpdate;
}
