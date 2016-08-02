package com.kapx.spring.core.beans.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ComponentScanApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ComponentScanApplication.class, args);
		ComponentScanBean bean = (ComponentScanBean) ctx.getBean("componentScanBean");
		bean.sayHello();
	}
}
