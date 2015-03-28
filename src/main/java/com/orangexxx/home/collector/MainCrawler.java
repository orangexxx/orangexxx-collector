package com.orangexxx.home.collector;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		HomeInfoCrawler crawler = (HomeInfoCrawler) context
				.getBean("homeInfoCrawler");

		try {
			for (int page = 111; page <= 918; ++page) {
				String url = "http://tuku.jia.com/tag/&page=" + page;
				
				crawler.visitURL(url);
				System.out.println(url);
			}
			System.out.println("OK!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
