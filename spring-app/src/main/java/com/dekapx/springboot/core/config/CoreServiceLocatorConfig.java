package com.dekapx.springboot.core.config;

import com.dekapx.springboot.core.command.Command;
import com.dekapx.springboot.core.processor.Processor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreServiceLocatorConfig {
    @Bean
    public FactoryBean commandFactoryBean() {
        return getServiceLocatorFactoryBean(Command.class);
    }

    @Bean
    public FactoryBean processorFactoryBean() {
        return getServiceLocatorFactoryBean(Processor.class);
    }

    private <T> ServiceLocatorFactoryBean getServiceLocatorFactoryBean(final Class<T> clazz) {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(clazz);
        return factoryBean;
    }
}
