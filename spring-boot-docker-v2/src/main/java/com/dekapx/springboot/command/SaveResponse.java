package com.dekapx.springboot.command;

import com.dekapx.springboot.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveResponse<E extends BaseEntity> {
    private E entity;
}
