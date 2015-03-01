package orangexxx.orangexxx_collector;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;

public class PicCrawler extends BreadthCrawler {

	 /*用一个整数，不断自增，来作为下载的图片的文件名*/
    AtomicInteger id=new AtomicInteger(0);
 
    @Override
    public void visit(Page page) {
 
    	System.out.println("visit:==============" + page.getUrl());
    }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PicCrawler crawler=new PicCrawler();
        crawler.addSeed("http://tuku.jia.com/");
        crawler.addRegex("http://.*tuku.jia.com/.*");
        crawler.setThreads(50);
        crawler.start(10);
	}

}
