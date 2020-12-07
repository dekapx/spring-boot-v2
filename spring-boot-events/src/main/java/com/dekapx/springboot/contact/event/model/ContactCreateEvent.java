package com.dekapx.springboot.contact.event.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ContactCreateEvent {
    private String event;
}
