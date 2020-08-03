package com.dekapx.springboot.app.config;

import com.dekapx.springboot.app.mapper.Mapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppServiceLocatorConfig {
    @Bean
    public FactoryBean mapperFactoryBean() {
        return getServiceLocatorFactoryBean(Mapper.class);
    }

    private <T> ServiceLocatorFactoryBean getServiceLocatorFactoryBean(final Class<T> clazz) {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(clazz);
        return factoryBean;
    }
}
