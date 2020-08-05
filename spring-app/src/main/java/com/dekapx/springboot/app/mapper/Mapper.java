package com.dekapx.springboot.app.mapper;

public interface Mapper<E, D> {
    void copy(E source, E target);
    E toEntity(D dto);
    D toDto(E entity);
    String getType();
}
