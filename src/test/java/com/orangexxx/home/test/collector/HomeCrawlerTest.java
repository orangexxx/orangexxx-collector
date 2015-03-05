package com.orangexxx.home.test.collector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class HomeCrawlerTest extends BreadthCrawler {
	
	private PrintWriter writer;
	
	
	
	@Override
	public void visit(Page page) {
		// System.out.println(page.getUrl());

			Document doc = Jsoup.parse(page.getHtml());
			Element result = doc.select("div.sift_result").first();
			if (result != null) {
				Element list = result.select("ul").first();
				if (list != null) {
					writer.println(page.getUrl());
				}
			}


	}


	public PrintWriter getWriter() {
		return writer;
	}


	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeCrawlerTest crawler = new HomeCrawlerTest();
		
		crawler.addSeed("http://tuku.jia.com/");
		crawler.addSeed("http://tuku.jia.com/tag/");
		crawler.addSeed("http://tuku.jia.com/tag/kongjian/1228/0");
		crawler.addSeed("http://tuku.jia.com/tag/fengge/1199/0");
		crawler.addRegex("http://tuku.jia.com/.*");
		crawler.setThreads(5);
		try {
			crawler.setWriter(new PrintWriter(new File("result.txt")));
			crawler.start(10);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			crawler.getWriter().flush();
			crawler.getWriter().close();
		}
	}

}
