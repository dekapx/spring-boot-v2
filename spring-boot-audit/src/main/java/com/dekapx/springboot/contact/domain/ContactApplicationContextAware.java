package com.dekapx.springboot.contact.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContactApplicationContextAware implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private ContactApplicationContextAware() {
    }

    public static void injectDependency(final Object object) {
        ContactApplicationContextAware.applicationContext.getAutowireCapableBeanFactory().autowireBean(object);
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        ContactApplicationContextAware.applicationContext = applicationContext;
    }
}
