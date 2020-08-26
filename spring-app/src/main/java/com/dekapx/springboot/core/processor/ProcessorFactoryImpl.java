package com.dekapx.springboot.core.processor;

import com.dekapx.springboot.app.mapper.Mapper;
import com.dekapx.springboot.core.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

import static com.dekapx.springboot.app.util.MessageUtils.getNotNullOrEmptyMessage;
import static org.springframework.util.Assert.notNull;

@Slf4j
@Component
public class ProcessorFactoryImpl implements ProcessorFactory {
    private List<Processor> processors;

    @Autowired
    public ProcessorFactoryImpl(final List<Processor> processors) {
        this.processors = List.copyOf(processors);
    }

    @Override
    public <T extends Processor> T getProcessor(Class<T> clazz) {
        notNull("processor Type", getNotNullOrEmptyMessage("processor Type"));
        log.info("Retrieve the bean instance of Processor type [{}]", clazz.getTypeName());
        try {
            return (T) this.processors
                    .stream()
                    .filter(isMatchingType(clazz.getTypeName()))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        } catch (Exception e) {
            log.error("Invalid mapper type.");
            throw new ResourceNotFoundException("Invalid mapper type.", e);
        }
    }

    private Predicate<Processor> isMatchingType(final String typeName) {
        return processor -> processor.getClass().getTypeName().equals(typeName);
    }
}
