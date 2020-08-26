package com.dekapx.springboot.core.processor;

@FunctionalInterface
public interface ProcessorExecutor {
    void execute(Processor processor, Object[] args);
}
