package com.kapx.spring.core.beans.annotation;

import org.springframework.stereotype.Component;

import com.kapx.spring.core.beans.xml.HelloBean;

@Component("componentScanBean")
public class ComponentScanBean implements HelloBean {
	public void sayHello() {
		System.out.println("Hello, I'm a Component Scan Bean");
	}
}
