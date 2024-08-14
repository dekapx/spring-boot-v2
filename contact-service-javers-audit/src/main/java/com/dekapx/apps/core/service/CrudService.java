package com.dekapx.apps.core.service;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CrudService<Entity, Model> {
    List<Model> findAll();

    Model findById(Long id);

    Model findBySpecification(Specification<Entity> specification);

    Model save(Model model);

    Model update(Long id, Model model);

    void delete(Long id);
}
