package com.dekapx.springboot.event.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ContactCreateEvent implements Event {
    private String event;
}
