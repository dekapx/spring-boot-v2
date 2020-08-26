package com.dekapx.springboot.core.processor;

@FunctionalInterface
public interface Processor {
    void process(final Object[] args);
}
