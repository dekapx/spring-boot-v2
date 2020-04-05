package com.dekapx.springboot.batch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchEntityWrapper<T extends AbstractBaseEntity> {
    private T entity;
    private String statusKey;
}
