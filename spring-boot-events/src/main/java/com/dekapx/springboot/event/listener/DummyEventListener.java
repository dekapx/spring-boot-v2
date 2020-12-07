package com.dekapx.springboot.event.listener;

import com.dekapx.springboot.event.model.DummyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DummyEventListener {
    @EventListener
    public void onApplicationEvent(final DummyEvent event) {
        log.info("Received spring dummyEvent - {}", event.getMessage());
    }
}
