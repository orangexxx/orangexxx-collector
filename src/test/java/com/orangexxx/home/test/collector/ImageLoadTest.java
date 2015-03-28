package com.orangexxx.home.test.collector;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class ImageLoadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File imageFile = new File("C:/test.jsp");
		try {
			if (!imageFile.exists()) {
				imageFile.createNewFile();
				URL url = new URL("http://tgi1.jia.com/113/766/13766193.jpg");
				InputStream iStream = url.openConnection().getInputStream();
				FileOutputStream oStream = new FileOutputStream(imageFile);
				int b = 0;
				while ((b=iStream.read())!= -1) {
					oStream.write(b);
				}
				oStream.flush();
				oStream.close();
				iStream.close();
				System.out.println("OK!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
