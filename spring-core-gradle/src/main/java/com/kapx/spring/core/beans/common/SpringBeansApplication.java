package com.kapx.spring.core.beans.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.kapx.spring.core.beans.annotation.ComponentScanBean;
import com.kapx.spring.core.beans.java.JavaConfigBean;
import com.kapx.spring.core.beans.xml.HelloBean;
import com.kapx.spring.core.beans.xml.XmlBean;

@SpringBootApplication
@ComponentScan("com.kapx.spring.core.beans")
@ImportResource("classpath*:spring-context/applicationContext.xml")
public class SpringBeansApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBeansApplication.class, args);

		List<HelloBean> helloBeans = new ArrayList<>();
		helloBeans.add((ComponentScanBean) ctx.getBean("componentScanBean"));
		helloBeans.add((JavaConfigBean) ctx.getBean("javaConfigBean"));
		helloBeans.add((XmlBean) ctx.getBean("xmlBean"));

		for (HelloBean helloBean : helloBeans) {
			helloBean.sayHello();
		}
	}
}
