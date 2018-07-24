package com.dekapx.springbootdocker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ServerDto {
    private long id;
    private String name;
}
