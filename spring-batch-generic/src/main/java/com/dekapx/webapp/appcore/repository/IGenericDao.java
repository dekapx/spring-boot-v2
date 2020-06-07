package com.dekapx.webapp.appcore.repository;

import java.io.Serializable;

public interface IGenericDao<T extends Serializable> {

    void setClazz(Class<T> clazz);

    T findOne(Long id);
    void create(T entity);
}
