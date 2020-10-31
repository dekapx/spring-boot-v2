package com.dekapx.springboot.service.impl;

import com.dekapx.springboot.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("greetingService")
public class GreetingServiceES implements GreetingService {
    @Override
    public String sayHello() {
        return "Hello ! World - ES";
    }
}
