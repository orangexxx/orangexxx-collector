package com.orangexxx.home.imageCollector;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ZoomImage {

	public void zoom(File origin, File dis) {
		BufferedImage img = null;
		try {
			if (origin.canRead()) {
				img = ImageIO.read(origin);
			}
			if (img!=null) {
				img = zoomImage(img);
				ImageIO.write(img, "JPG", dis);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage zoomImage(BufferedImage img) {
		int width = img.getWidth();
		int height = img.getHeight();
		float time =1.0f;
		if (width > height) {
			
			time = 300.0f/height;
			width = (int)(width*time);
			height = 300;
		} else {
			
			time = 300.0f/width;
			height = (int)(height*time);
			width = 300;
		}
		BufferedImage newImg = new BufferedImage(width, height, img.getType());
		Graphics g = newImg.getGraphics();
		g.drawImage(img, 0, 0, width, height, null);
		g.dispose();
		return newImg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZoomImage zoo = new ZoomImage();
		zoo.zoom(new File("C:/1.jpg"), new File("C:/1-new.jpg"));
	}

}
