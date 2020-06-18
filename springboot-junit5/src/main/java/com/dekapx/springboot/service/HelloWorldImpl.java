package com.dekapx.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello(String arg) {
        return "Hello ! " + arg;
    }
}
