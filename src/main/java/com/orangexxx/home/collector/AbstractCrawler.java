package com.orangexxx.home.collector;

import java.io.IOException;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;

public abstract class AbstractCrawler extends BreadthCrawler {

	public abstract void visitURL (String url) throws IOException;
}
