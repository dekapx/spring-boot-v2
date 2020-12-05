package com.dekapx.springboot.event.listener;

import com.dekapx.springboot.event.model.Event;
import com.dekapx.springboot.event.model.GenericAppEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppEventListener {
    @EventListener
    public void onApplicationEvent(GenericAppEvent<? extends Event> appEvent) {
        final Event event = appEvent.getEvent();
        log.info("Received spring custom event - {}", event.toString());
    }
}
