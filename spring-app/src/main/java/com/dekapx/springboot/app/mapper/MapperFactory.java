package com.dekapx.springboot.app.mapper;

public interface MapperFactory {
    <T extends Mapper> T getMapper(Class<T> clazz);
}
