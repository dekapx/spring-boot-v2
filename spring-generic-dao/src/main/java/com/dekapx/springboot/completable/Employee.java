package com.dekapx.springboot.completable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
}
