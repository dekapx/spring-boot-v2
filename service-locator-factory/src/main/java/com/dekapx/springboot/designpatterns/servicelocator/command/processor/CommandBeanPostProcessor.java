package com.dekapx.springboot.designpatterns.servicelocator.command.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("saveCommand")) {
            log.info("---------------------- CommandBeanPostProcessor.postProcessBeforeInitialization ----------------------");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("saveCommand")) {
            log.info("---------------------- CommandBeanPostProcessor.postProcessAfterInitialization ----------------------");
        }
        return null;
    }
}
