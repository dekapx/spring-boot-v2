package com.dekapx.myapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello() {
        log.info("GreetingService invoked...");
        return "Hello ! World";
    }
}
