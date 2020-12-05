package com.dekapx.springboot.event.publisher;

import com.dekapx.springboot.event.model.Event;
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

    public void publishEvent(final Event event) {
        final GenericAppEvent<Event> appEvent = new GenericAppEvent<Event>(this, event);
        this.applicationEventPublisher.publishEvent(appEvent);
        log.info("Events send to listener...");
    }
}
