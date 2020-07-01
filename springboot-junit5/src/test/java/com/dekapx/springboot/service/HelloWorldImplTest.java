package com.dekapx.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class HelloWorldImplTest {
    private HelloWorld helloWorld;

    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
        helloWorld = new HelloWorldImpl();
    }

    @AfterEach
    void tearDown() {
        log.info("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        log.info("@AfterAll - executed after all test methods.");
    }

    @Test
    public void sayHello_withValidArg_returnValidResponse() {
        String actual = helloWorld.sayHello("DeKapx");
        String expected = "Hello ! DeKapx";
        assertAll("actual",
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }
}
