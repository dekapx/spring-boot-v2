package com.kapx.spring.core.beans.xml;

public class XmlBean implements HelloBean {
	@Override
	public void sayHello() {
		System.out.println("Hello, I'm a XML Bean");
	}
}