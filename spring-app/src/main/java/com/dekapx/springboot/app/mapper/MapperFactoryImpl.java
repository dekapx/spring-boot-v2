package com.dekapx.springboot.app.mapper;

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
public class MapperFactoryImpl implements MapperFactory {
    private List<Mapper> mappers;

    @Autowired
    public MapperFactoryImpl(final List<Mapper> mappers) {
        this.mappers = List.copyOf(mappers);
    }

    @Override
    public <T extends Mapper> T getMapper(final Class<T> clazz) {
        notNull("mapper Type", getNotNullOrEmptyMessage("mapper Type"));
        try {
            return (T) this.mappers
                    .stream()
                    .filter(isMatchingType(clazz.getTypeName()))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        } catch (Exception e) {
            log.error("Invalid mapper type.");
            throw new ResourceNotFoundException("Invalid mapper type.", e);
        }
    }

    private Predicate<Mapper> isMatchingType(final String typeName) {
        return mapper -> mapper.getType().equals(typeName);
    }
}
