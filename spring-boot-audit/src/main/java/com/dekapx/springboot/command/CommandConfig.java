package com.dekapx.springboot.command;

import com.dekapx.springboot.command.Command;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfig {
    @Bean
    public ServiceLocatorFactoryBean CommandFactoryServiceLocatorBean() {
        final ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(Command.class);
        return factoryBean;
    }

}
