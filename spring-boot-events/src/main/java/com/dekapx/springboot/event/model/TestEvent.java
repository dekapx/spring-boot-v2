package com.dekapx.springboot.event.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestEvent {
    private String message;
}
