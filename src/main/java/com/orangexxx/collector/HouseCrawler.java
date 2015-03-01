package com.orangexxx.collector;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class HouseCrawler extends BreadthCrawler {

	@Override
	public void visit(Page page) {
		System.out.println(page.getUrl());
		Document doc = Jsoup.parse(page.getHtml());
		Element result = doc.select("div.sift_result").first();
		if (result != null) {
			Element list = result.select("ul").first();
			if (list != null) {
				handleResultList(list);
			}
		}
	}
	
	public void visitURL(String url) throws Exception{
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
		Elements items = list.select("li.masonry-brick");
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
			if (url.contains("#")) {
				url = url.substring(0, url.indexOf("#"));
			}

		}
		Element img = desc.select("label.c_img").first();
		if (img != null) {
			imgCount = Integer.parseInt(img.text(), 0);
		}
		handleItemPic(url, imgCount);
		Element tag = item.select(".type").first();
		if (tag != null) {
			handleItemTag(tag);
		}
	}

	private void handleItemPic(String url, int count) {
		String imgUrl="";
		String imgInfo = "";
		for (int i=1; i<= count; i++){
			try {
				Document imgPage = Jsoup.connect(url + "#p=" + i).get();
				Element img = imgPage.select("img#bigpic.lazyload[src]").first();
				if (img != null ){
					imgUrl=img.attr("src").trim();
				}
				Element info = imgPage.select("p#pic_alt.txt_info").first();
				if (info!=null) {
					imgInfo = info.text().trim();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	private void handleItemTag(Element tagNode) {
		Elements tags = tagNode.select("a[href]");
		HashMap<String, String> tagMap = new HashMap<String, String>();
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
	}

	private void addTag(Map<String, String> map, String key, Element tag) {
		if (map.containsKey(key)) {
			map.put(key, map.get(key) + ":" + tag.text().trim());
		} else {
			map.put(key, tag.text().trim());
		}
	}

	public static void main(String[] args) throws Exception {
		HouseCrawler crawler = new HouseCrawler();
		//crawler.addSeed("http://tuku.jia.com/");
		//crawler.addSeed("http://tuku.jia.com/tag/");
		//crawler.addRegex("http://.*tuku.jia.com/.*");
		//crawler.setThreads(1);
		//crawler.start(10);
		crawler.visitURL("http://tuku.jia.com/tag/");
	}

}
