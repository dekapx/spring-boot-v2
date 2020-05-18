package com.dekapx.springboot.completable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AggregatedResponse {
    private Employee employee;
    private Address address;
}
