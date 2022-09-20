package net.dekapx.demoapp.config;

import net.dekapx.demoapp.handler.TradeHandler;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ServiceLocatorFactoryBean tradeHandlerServiceLocatorBean() {
        return createServiceLocatorFactoryBean(TradeHandler.class);
    }

    public ServiceLocatorFactoryBean createServiceLocatorFactoryBean(final Class clazz) {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(clazz);
        return factoryBean;
    }
}
