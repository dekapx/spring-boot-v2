package com.dekapx.springboot.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContactDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String status;
    private String modifiedBy;
}
