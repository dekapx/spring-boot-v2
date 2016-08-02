package com.kapx.spring.core.beans.java;

import com.kapx.spring.core.beans.xml.HelloBean;

public class JavaConfigBean implements HelloBean {
	@Override
	public void sayHello() {
		System.out.println("Hello, I'm a Java Config bean");
	}
}
