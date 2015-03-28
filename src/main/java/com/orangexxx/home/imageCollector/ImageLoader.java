package com.orangexxx.home.imageCollector;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import com.orangexxx.home.beans.HomeImage;

public class ImageLoader implements Runnable {

	public final static String PATH = "F:/homeImages2/";
	private HomeImage image;

	public ImageLoader(HomeImage homeImage) {
		this.image = homeImage;
	}

	public void run() {
		// TODO Auto-generated method stub
		File imageFile = new File(PATH + image.getmHomeID() + "-"
				+ image.getmID() + ".jpg");
		try {
			if (!imageFile.exists()) {
				imageFile.createNewFile();
				URL url = new URL(image.getmURL());
				InputStream iStream = url.openConnection().getInputStream();
				FileOutputStream oStream = new FileOutputStream(imageFile);
				int b = 0;
				while ((b=iStream.read())!= -1) {
					oStream.write(b);
				}
				oStream.flush();
				oStream.close();
				iStream.close();
				System.out.println(image.getmURL());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HomeImage getImage() {
		return image;
	}

	public void setImage(HomeImage image) {
		this.image = image;
	}

}
