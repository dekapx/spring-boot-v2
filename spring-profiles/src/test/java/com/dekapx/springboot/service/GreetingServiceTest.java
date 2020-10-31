package com.dekapx.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class GreetingServiceTest {
    @Autowired
    @Qualifier("greetingService")
    private GreetingService greetingService;

    @Test
    void sayHello() {
        String result = this.greetingService.sayHello();
        assertAll("result",
                () -> assertNotNull(result)
        );
        log.info("------------------ {} ------------------", result);
    }
}