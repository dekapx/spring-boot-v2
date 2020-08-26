package com.dekapx.springboot.core.processor;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessorExecutorImpl implements ProcessorExecutor {
    @Override
    public void execute(final List<Processor> processors) {
        processors.forEach(p -> p.process());
    }
}
