package com.dekapx.springboot.event.model;

import org.springframework.context.ApplicationEvent;

public class GenericAppEvent<String> extends ApplicationEvent {
    private String message;

    public GenericAppEvent(final Object source, final String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
