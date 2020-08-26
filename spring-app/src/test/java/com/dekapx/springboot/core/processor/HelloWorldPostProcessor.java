package com.dekapx.springboot.core.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloWorldPostProcessor implements Processor {
    @Override
    public void process(final Object[] args) {
        log.info("HelloWorldPostProcessor.process()...");
        log.info("Argument value is: [{}]", args[0]);
    }
}
