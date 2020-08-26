package com.dekapx.springboot.core.processor;

import com.dekapx.springboot.core.annotation.PostProcessor;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldImpl implements HelloWorld {
    @Override
    @PostProcessor(processorTypes = {HelloWorldPostProcessor.class})
    public String sayHello(final String arg) {
        return "Hello ! " + arg;
    }
}
