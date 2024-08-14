package com.dekapx.apps.core.mapper;

import com.dekapx.apps.core.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class MapperFactoryImpl implements MapperFactory {
    private List<Mapper> mappers;

    @Autowired
    public MapperFactoryImpl(final List<Mapper> mappers) {
        this.mappers = new ArrayList<>(mappers.size());
        this.mappers.addAll(mappers);
    }

    @Override
    public Mapper getMapper(final Class clazz) {
        return this.mappers
                .stream()
                .filter(isMatchingType(clazz))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No mapper found for type [%s]", clazz.getTypeName())));
    }

    private Predicate<Mapper> isMatchingType(final Class clazz) {
        return mapper -> mapper.getType().equals(clazz.getTypeName());
    }
}