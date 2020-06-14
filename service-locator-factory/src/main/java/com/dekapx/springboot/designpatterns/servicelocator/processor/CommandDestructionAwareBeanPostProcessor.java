package com.dekapx.springboot.designpatterns.servicelocator.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (beanName.equals("saveCommand")) {
            log.info("---------------------- CommandDestructionAwareBeanPostProcessor.postProcessBeforeDestruction {} ----------------------", beanName);
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("saveCommand")) {
            log.info("---------------------- CommandDestructionAwareBeanPostProcessor.postProcessBeforeInitialization {} ----------------------", beanName);
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("saveCommand")) {
            log.info("---------------------- CommandDestructionAwareBeanPostProcessor.postProcessAfterInitialization {} ----------------------", beanName);
        }
        return null;
    }
}
