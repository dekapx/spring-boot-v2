package com.dekapx.springboot.core.processor;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

abstract class AbstractProcessorHandler {
    @Autowired
    private ProcessorFactory processorFactory;

    protected List<Processor> getProcessors(final Class[] processorTypes) {
        final List<Processor> processors = new LinkedList<>();
        Arrays.stream(processorTypes).forEach(clazz -> toProcessors.accept(clazz, processors));
        return processors;
    }

    private BiConsumer<Class<? extends Processor>, List<Processor>> toProcessors = (clazz, processors) ->
            processors.add(this.processorFactory.getProcessor(clazz));
}
