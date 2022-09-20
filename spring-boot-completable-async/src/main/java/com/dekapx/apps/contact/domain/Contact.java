package com.dekapx.apps.contact.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
}
