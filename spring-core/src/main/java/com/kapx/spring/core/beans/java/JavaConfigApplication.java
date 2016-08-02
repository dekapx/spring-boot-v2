package com.kapx.spring.core.beans.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JavaConfig.class)
public class JavaConfigApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JavaConfigApplication.class, args);
		JavaConfigBean bean = (JavaConfigBean) ctx.getBean("javaConfigBean");
		bean.sayHello();
	}
}
