package com.dekapx.springboot.core.convertor;

public interface Convertor<E, D> {
    E toEntity(D dto);

    D toDto(E entity);

    void copyAttributes (E entity, D dto);
}
