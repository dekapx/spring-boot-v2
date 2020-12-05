package com.dekapx.springboot.event.publisher;

import com.dekapx.springboot.event.model.GenericAppEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        log.info("Publishing custom event. ");
        GenericAppEvent genericAppEvent = new GenericAppEvent(this, message);
        this.applicationEventPublisher.publishEvent(genericAppEvent);
    }
}
