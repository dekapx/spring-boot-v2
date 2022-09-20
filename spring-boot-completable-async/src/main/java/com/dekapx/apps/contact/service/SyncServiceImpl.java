package com.dekapx.apps.contact.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class SyncServiceImpl implements SyncService {
    @SneakyThrows
    @Override
    public void sendEvent(String event) {
        TimeUnit.SECONDS.sleep(7);
        log.info("Event [{}] sent...", event);
    }
}
