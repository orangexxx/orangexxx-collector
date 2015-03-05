package com.orangexxx.home.test.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orangexxx.home.beans.HomeImage;
import com.orangexxx.home.service.HomeImageService;
import com.orangexxx.home.service.impl.HomeImageServiceImpl;

public class HomeImageTest {

	public static void testInsert(HomeImageService service) {
		HomeImage image = new HomeImage.Builder().homeID(1).info("new2")
				.url("www.ww2w.com").build();
		int id = service.insertObject(image);
		System.out.println("newID:" + id);
	}
	
	public static void testQuery(HomeImageService service) {
		List<HomeImage> result = service.queryObject(0, 5);
		for (HomeImage img : result) {
			System.out.println(img.getmID() + "::" + img.getmHomeID() + "::" + img.getmInfo() + "::"
					+ img.getmURL());
		}
	}

	public static void testUpdate(HomeImageService service) {
		HomeImage image = new HomeImage.Builder()
				.homeID(2)
				.info("changeText")
				.url("www.update.com")
				.build();
		service.updateObject(image, 2);
	}
	
	public static void testQueryColumn(HomeImageService service) {
		Map<String, String>info = new HashMap<String, String>();
		info.put("house_id", "2");
		//info.put("info", "orangexxx");
		info.put("url", "www.fx.com");
		List<HomeImage> result = service.queryObjectByColumn(info, 0, 5);
		for (HomeImage img:result){
			System.out.println(img.getmHomeID() + "::" + img.getmInfo() + "::"
					+ img.getmURL());
		}
	}
	
	public static void testDelete(HomeImageService service) {
		service.deleteObject(4);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeImageService service = (HomeImageService) HomeImageServiceImpl
				.getInstance();
		//testInsert(service);
		//testUpdate(service);
		//testQueryColumn(service);
		testDelete(service);
		testQuery(service);
	}

}
