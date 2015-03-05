package com.orangexxx.home.test.database;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IService service = (IService) factory.getBean("service");
		service.service("xia yang");
		factory.destroySingletons();
	}

}
