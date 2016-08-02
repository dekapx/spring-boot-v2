package com.kapx.spring.core.beans.xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:spring-context/applicationContext.xml")
public class XmlApplication {
	public static void main(String[] args) {
		final ApplicationContext ctx = SpringApplication.run(XmlApplication.class, args);
		final XmlBean bean = (XmlBean) ctx.getBean("xmlBean");
		bean.sayHello();
	}
}
