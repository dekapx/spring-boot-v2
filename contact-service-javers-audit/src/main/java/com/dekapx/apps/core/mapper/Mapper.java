package com.dekapx.apps.core.mapper;

public interface Mapper<Entity, Model> {
    Entity toEntity(Model model);

    Model toModel(Entity entity);

    void copyProperties(Entity entity, Model model);

    String getType();
}
