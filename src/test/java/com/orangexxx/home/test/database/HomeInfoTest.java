package com.orangexxx.home.test.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orangexxx.home.beans.HomeInfo;
import com.orangexxx.home.service.HomeInfoService;
import com.orangexxx.home.service.impl.HomeInfoServiceImpl;

public class HomeInfoTest {

	public static void testQuery(HomeInfoService service){
		List<HomeInfo> result = service.queryObject(0, 5);
		for(HomeInfo info : result) {
			System.out.println(info.getmID() + "::" 
						+ info.getmTitle() + "::" 
						+ info.getmSpace() + "::"
						+ info.getmStyle() + "::"
						+ info.getmPart() + "::"
						+ info.getmShape() +"::"
						+ info.getmStuff() + "::"
						+ info.getmDesigner() + "::"
						+ info.getmBudget() + "::"
						+ info.getmSize() + "::"
						+ info.getmFeel() + "::"
						+ info.getmColor() + "::" 
						+ info.getmURL());
		}
	}
	
	public static void testQueryColumn(HomeInfoService service) {
		Map<String, String> in = new HashMap<String, String>();
		in.put("title", "title1");
		in.put("space", "space1");
		in.put("style", "style1");
		in.put("part", "part1");
		in.put("shape", "shape1");
		in.put("stuff", "stuff1");
		in.put("designer", "designer1");
		in.put("budget", "budget1");
		in.put("size", "size1");
		in.put("feel", "feel1");
		in.put("color", "color1");
		in.put("url", "url1");
		List<HomeInfo> result= service.queryObjectByColumn(in, 0, 5);
		for(HomeInfo info : result) {
			System.out.println(info.getmID() + "::" 
						+ info.getmTitle() + "::" 
						+ info.getmSpace() + "::"
						+ info.getmStyle() + "::"
						+ info.getmPart() + "::"
						+ info.getmShape() +"::"
						+ info.getmStuff() + "::"
						+ info.getmDesigner() + "::"
						+ info.getmBudget() + "::"
						+ info.getmSize() + "::"
						+ info.getmFeel() + "::"
						+ info.getmColor() + "::" 
						+ info.getmURL());
		}
	}
	
	public static void testDelete(HomeInfoService service) {
		service.deleteObject(2);
	}
	
	public static void testUpdate(HomeInfoService service) {
		HomeInfo info = new HomeInfo.Builder()
					.title("ctitle2")
					.space("cspace2")
					.style("cstyle2")
					.part("cpart2")
					.stuff("cstuff2")
					.shape("cshape2")
					.designer("cdesigner2")
					.budget("cbudget2")
					.size("csize2")
					.feel("cfeel2")
					.color("ccolor2")
					.url("curl2")
					.build();
		service.updateObject(info, 2);
	}
	
	public static void testInsert(HomeInfoService service) {
		HomeInfo info = new HomeInfo.Builder()
		.title("title2")
		.space("space2")
		.style("style2")
		.part("part2")
		.stuff("stuff2")
		.shape("shape2")
		.designer("designer2")
		.budget("budget2")
		.size("size2")
		.feel("feel2")
		.color("color2")
		.url("url2")
		.build();
		int id=service.insertObject(info);
		System.out.println(id);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeInfoService service = (HomeInfoService)HomeInfoServiceImpl.getInstance();
		//testInsert(service);
		//testUpdate(service);
		//testQuery(service);
		//testQueryColumn(service);
		testDelete(service);
		testQuery(service);
	}

}
