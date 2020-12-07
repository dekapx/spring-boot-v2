package com.dekapx.springboot.core.event.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Primary
@Component
public class AppEventPublisherImpl implements AppEventPublisher {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public <T extends ApplicationEvent> void publishEvent(final T event) {
        log.info("Event of type [{}] received, publishing it...", event.getClass().getTypeName());
        this.eventPublisher.publishEvent(event);
    }
}

