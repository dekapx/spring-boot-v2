package com.dekapx.springboot.contact.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String houseNo;
    private String street;
    private String city;
    private String zipcode;
    private String county;
    private String country;
}
