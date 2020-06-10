package com.dekapx.webapp.appcore.batch.model;

import com.dekapx.webapp.appcore.model.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ItemReaderWrapper<T extends AbstractBaseEntity> {
    private T entity;
}
