package com.dekapx.springboot.event.model;

import org.springframework.context.ApplicationEvent;

public class GenericAppEvent<T> extends ApplicationEvent {
    private T event;

    public GenericAppEvent(final Object source, final T event) {
        super(source);
        this.event = event;
    }

    public T getEvent() {
        return event;
    }
}
