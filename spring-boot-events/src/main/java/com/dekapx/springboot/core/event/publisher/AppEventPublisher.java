package com.dekapx.springboot.core.event.publisher;

import org.springframework.context.ApplicationEvent;

public interface AppEventPublisher {
    <T extends ApplicationEvent> void publishEvent(T event);
}
