package com.dekapx.springboot.core.util;

import com.dekapx.springboot.app.mapper.Mapper;
import com.dekapx.springboot.app.mapper.MapperFactory;
import com.dekapx.springboot.core.annotation.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanUtilsImpl implements BeanUtils{
    private MapperFactory mapperFactory;

    @Autowired
    public BeanUtilsImpl(final MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    @Override
    public <T> Mapper getMapper(final Class<T> clazz) {
        final EntityMapper entityMapper = clazz.getAnnotation(EntityMapper.class);
        final Class<Mapper> mapperClass = entityMapper.mapperClass();
        return this.mapperFactory.getMapper(mapperClass);
    }
}
