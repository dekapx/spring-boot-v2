package com.dekapx.springboot.contact.event.model;

import org.springframework.context.ApplicationEvent;

public class ContactApplicationEvent<T> extends ApplicationEvent {
    private T event;

    public ContactApplicationEvent(final Object source, final T event) {
        super(source);
        this.event = event;
    }

    public T getEvent() {
        return event;
    }
}

