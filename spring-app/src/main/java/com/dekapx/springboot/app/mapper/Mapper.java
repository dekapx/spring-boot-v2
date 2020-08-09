package com.dekapx.springboot.app.mapper;

import java.util.List;

public interface Mapper<E, D> {
    void copy(E source, E target);

    E toEntity(D dto);
    List<E> toEntity(List<D> dto);

    D toDto(E entity);
    List<D> toDto(List<E> entity);

    String getType();
}
