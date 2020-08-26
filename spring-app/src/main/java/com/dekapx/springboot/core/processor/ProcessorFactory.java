package com.dekapx.springboot.core.processor;

@FunctionalInterface
public interface ProcessorFactory {
    <T extends Processor> T getProcessor(Class<T> clazz);
}
