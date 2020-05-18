package com.dekapx.springboot.config;

import com.dekapx.springboot.factory.FileWriter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AppConfig {
    @Bean("parserFactory")
    public FactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(FileWriter.class);
        return factoryBean;
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }
}
