package com.dekapx.springboot.app.processor;

import com.dekapx.springboot.core.processor.Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingProcessor implements Processor {
    @Override
    public void process() {
        log.info("Perform logging...");
    }
}
