package com.dekapx.springboot.core.util;

import com.dekapx.springboot.app.mapper.Mapper;

public interface BeanUtils {
    <T> Mapper getMapper(Class<T> clazz);
}
