package com.orangexxx.home.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFactory {

	
	private static ApplicationContext getContext () {
		return new ClassPathXmlApplicationContext(
				"applicationContext.xml");

	}
	public static HomeInfoService getHomeInfoService() {
		return (HomeInfoService)getContext().getBean(EnumService.HOME_INFO_SERVICE);
	}
	
	public static HomeImageService getHomeImageSerivce() {
		return (HomeImageService)getContext().getBean(EnumService.HOME_IMAGE_SERVICE);
	}
}
