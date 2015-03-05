package com.orangexxx.home.collector;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

import com.orangexxx.home.beans.HomeImage;
import com.orangexxx.home.beans.HomeInfo;
import com.orangexxx.home.service.HomeImageService;
import com.orangexxx.home.service.HomeInfoService;

public class HomeInfoCrawler extends BreadthCrawler {

	private HomeInfoService homeInfoService;
	private HomeImageService homeImageService;
	
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
		HomeInfo homeInfo = new HomeInfo();

		if (t != null) {
			homeInfo.setmTitle(t.text().trim());
			homeInfo.setmURL(t.attr("href").trim());
		}
		Element tag = item.select(".type").first();
		if (tag != null) {
			handleItemTag(tag, homeInfo);
		}
		int home_id = homeInfoService.insertObject(homeInfo);
		handleItemPic(homeInfo.getmURL(), home_id);
	}

	private void handleItemPic(String url, int home_id) {
		HomeImage homeImage = new HomeImage();
		homeImage.setmHomeID(home_id);
		try {
			Document imgPage = Jsoup.connect(url).get();
			// System.out.println(imgPage.toString());
			Element scrollNode = imgPage
					.select("div.img_scroll#small_pic_list").first();
			if (scrollNode != null) {
				Elements images = scrollNode.select("li[rel]");
				for (Element img : images) {
					homeImage.setmURL(img.attr("rel").trim());
					homeImage.setmInfo(img.attr("alt").trim());
				}
			}
			homeImageService.insertObject(homeImage);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void handleItemTag(Element tagNode, HomeInfo homeInfo) {
		Elements tags = tagNode.select("a[href]");
		//HashMap<String, String> tagMap = new HashMap<String, String>();
		//System.out.print("tags: ");
		for (Element tag : tags) {	
			String href = tag.attr("href");
			String tagText = tag.text().trim();
			if (href.contains("kongjian")) {
				if (StringUtils.isEmpty(homeInfo.getmSpace())){
					homeInfo.setmSpace(tagText);
				} else {
					homeInfo.setmSpace(homeInfo.getmSpace() + ":" + tagText);
				}
			} else if (href.contains("fengge")) {
				if(StringUtils.isEmpty(homeInfo.getmStyle())) {
					homeInfo.setmStyle(tagText);
				} else {
					homeInfo.setmStyle(homeInfo.getmStyle() + ":" +tagText);
				}
			} else if (href.contains("jubu")) {
				if (StringUtils.isEmpty(homeInfo.getmPart())) {
					homeInfo.setmPart(tagText);
				} else {
					homeInfo.setmPart(homeInfo.getmPart() + ":" + tagText);
				}
			} else if (href.contains("huxing")) {
				if (StringUtils.isEmpty(homeInfo.getmShape())) {
					homeInfo.setmShape(tagText);
				} else {
					homeInfo.setmShape(homeInfo.getmShape() + ":" + tagText);
				}
			} else if (href.contains("wupin")) {
				if (StringUtils.isEmpty(homeInfo.getmStuff())) {
					homeInfo.setmStuff(tagText);
				} else {
					homeInfo.setmStuff(homeInfo.getmStuff() + ":" + tagText);
				}
			} else if (href.contains("shejishi")) {
				if (StringUtils.isEmpty(homeInfo.getmDesigner())) {
					homeInfo.setmDesigner(tagText);
				} else {
					homeInfo.setmDesigner(homeInfo.getmDesigner() + ":" + tagText);
				}
			} else if (href.contains("yusuan")) {
				if (StringUtils.isEmpty(homeInfo.getmBudget())) {
					homeInfo.setmBudget(tagText);
				} else {
					homeInfo.setmBudget(homeInfo.getmBudget() + ":" + tagText);
				}
			} else if (href.contains("mianji")) {
				if (StringUtils.isEmpty(homeInfo.getmSize())) {
					homeInfo.setmSize(tagText);
				} else {
					homeInfo.setmSize(homeInfo.getmSize() + ":" + tagText);
				}
			} else if (href.contains("ganjue")) {
				if (StringUtils.isEmpty(homeInfo.getmFeel())) {
					homeInfo.setmFeel(tagText);
				} else {
					homeInfo.setmFeel(homeInfo.getmFeel() + ":" + tagText);
				}
			} else if (href.contains("yanse")) {
				if (StringUtils.isEmpty(homeInfo.getmColor())) {
					homeInfo.setmColor(tagText);
				} else {
					homeInfo.setmColor(homeInfo.getmColor() + ":" + tagText);
				}
			}
		}
	}
	
	
	public HomeInfoService getHomeInfoService() {
		return homeInfoService;
	}
	public void setHomeInfoService(HomeInfoService homeInfoService) {
		this.homeInfoService = homeInfoService;
	}
	public HomeImageService getHomeImageService() {
		return homeImageService;
	}
	public void setHomeImageService(HomeImageService homeImageService) {
		this.homeImageService = homeImageService;
	}

	
	

}
