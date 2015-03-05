package com.orangexxx.home.test.collector;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JTest {

	public void visitURL(String url) throws Exception {
		Document doc = Jsoup.connect(url).get();
		Element result = doc.select("div.sift_result").first();
		if (result != null) {
			Element list = result.select("ul").first();
			if (list != null) {
				handleResultList(list);
			}
		}
	}

	private void handleResultList(Element list) {
		Elements items = list.select("li");
		for (Element item : items) {
			Element desc = item.select(".describe").first();
			if (desc != null) {
				handleResultItem(item);
			}
		}
	}

	private void handleResultItem(Element item) {
		Element desc = item.select(".describe").first();
		Element t = desc.select("a.title").first();
		String title = "";
		String url = "";
		int imgCount = 0;

		if (t != null) {
			title = t.text();
			url = t.attr("href");

		}
		Element img = desc.select("label.c_img").first();
		if (img != null) {
			imgCount = Integer.parseInt(img.text().replace("共", "")
					.replace("张图", ""));
		}
		System.out.println("title:"+title+"   url:"+url+ "   photos:" + imgCount);
		handleItemPic(url);
		Element tag = item.select(".type").first();
		if (tag != null) {
			handleItemTag(tag);
		}
	}

	private void handleItemPic(String url) {
		String imgUrl = "";
		String imgInfo = "";

		try {
			Document imgPage = Jsoup.connect(url).get();
			// System.out.println(imgPage.toString());
			Element scrollNode = imgPage
					.select("div.img_scroll#small_pic_list").first();
			if (scrollNode != null) {
				Elements images = scrollNode.select("li[rel]");
				for (Element img : images) {
					imgUrl = img.attr("rel").trim();
					imgInfo = img.attr("alt").trim();
					System.out.println(imgUrl);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	private void handleItemTag(Element tagNode) {
		Elements tags = tagNode.select("a[href]");
		HashMap<String, String> tagMap = new HashMap<String, String>();
		System.out.print("tags: ");
		for (Element tag : tags) {
			String href = tag.attr("href");
			if (href.contains("kongjian")) {
				addTag(tagMap, "space", tag);
			} else if (href.contains("fengge")) {
				addTag(tagMap, "style", tag);
			} else if (href.contains("jubu")) {
				addTag(tagMap, "part", tag);
			} else if (href.contains("huxing")) {
				addTag(tagMap, "shape", tag);
			} else if (href.contains("wupin")) {
				addTag(tagMap, "stuff", tag);
			} else if (href.contains("shejishi")) {
				addTag(tagMap, "designer", tag);
			} else if (href.contains("yusuan")) {
				addTag(tagMap, "budget", tag);
			} else if (href.contains("mianji")) {
				addTag(tagMap, "size", tag);
			} else if (href.contains("ganjue")) {
				addTag(tagMap, "feel", tag);
			} else if (href.contains("yanse")) {
				addTag(tagMap, "color", tag);
			}
		}
		System.out.println();
	}

	private void addTag(Map<String, String> map, String key, Element tag) {
		if (map.containsKey(key)) {
			map.put(key, map.get(key) + ":" + tag.text().trim());
		} else {
			map.put(key, tag.text().trim());
		}
		System.out.print(tag.text().trim()+":");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTest test = new JTest();
		try {
			test.visitURL("http://tuku.jia.com/tag/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
