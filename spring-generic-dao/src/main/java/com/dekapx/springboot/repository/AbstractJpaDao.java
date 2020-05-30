package com.dekapx.springboot.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class AbstractJpaDao<T extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOne(final Long id) {
        return entityManager.find(clazz, id);
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }
}
