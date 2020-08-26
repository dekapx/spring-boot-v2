package com.dekapx.springboot.core.processor;

import org.springframework.stereotype.Component;

@Component
public class ProcessorExecutorImpl implements ProcessorExecutor {
    @Override
    public void execute(final Processor processor, final Object[] args) {
        processor.process(args);
    }
}
