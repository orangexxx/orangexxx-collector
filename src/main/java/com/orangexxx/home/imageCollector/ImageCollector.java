package com.orangexxx.home.imageCollector;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.orangexxx.home.beans.HomeImage;
import com.orangexxx.home.service.HomeImageService;
import com.orangexxx.home.service.impl.HomeImageServiceImpl;

public class ImageCollector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("F:/homeImages2");
			if (!file.exists()) {
				file.mkdir();
			}
			HomeImageService dbImageService = HomeImageServiceImpl.getInstance();
			ExecutorService service = Executors.newFixedThreadPool(30);
			List<HomeImage> images = dbImageService.queryObject(2, 60000);
			for (HomeImage img : images) {
				service.execute(new ImageLoader(img));
			}
			service.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("OK!");
	}

}
