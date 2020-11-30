package com.dekapx.springboot.contact.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ContactDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
