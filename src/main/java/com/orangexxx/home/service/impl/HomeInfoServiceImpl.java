package com.orangexxx.home.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.orangexxx.home.beans.HomeInfo;
import com.orangexxx.home.service.AbstractService;
import com.orangexxx.home.service.HomeInfoService;

public class HomeInfoServiceImpl extends AbstractService implements
		HomeInfoService {
	
	
	public static Object getInstance() {
		// TODO Auto-generated method stub
		return getContext().getBean("homeInfoService");
	}

	public int insertObject(HomeInfo obj) {
		// TODO Auto-generated method stub
		JdbcTemplate template = getJdbcTemplate();
		template.update("insert into house (title, space, style, part, shape, stuff, designer, budget, size, feel, color, url) values (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] {
			obj.getmTitle(),
			obj.getmSpace(),
			obj.getmStyle(),
			obj.getmPart(),
			obj.getmShape(),
			obj.getmStuff(),
			obj.getmDesigner(),
			obj.getmBudget(),
			obj.getmSize(),
			obj.getmFeel(),
			obj.getmColor(),
			obj.getmURL()
		});
		return template.queryForInt("select @@identity");
	}

	public void deleteObject(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate template = getJdbcTemplate();
		template.update("delete from house where house_id = " + id);
	}

	public void updateObject(HomeInfo obj, int id) {
		// TODO Auto-generated method stub
		JdbcTemplate template = getJdbcTemplate();
		template.update("update house set title=?, space=?, style=?, part=?, shape=?, stuff=?, designer=?, budget=?, size=?, feel=?, color=?, url=? where house_id = " + id, new Object[] {
				obj.getmTitle(),
				obj.getmSpace(),
				obj.getmStyle(),
				obj.getmPart(),
				obj.getmShape(),
				obj.getmStuff(),
				obj.getmDesigner(),
				obj.getmBudget(),
				obj.getmSize(),
				obj.getmFeel(),
				obj.getmColor(),
				obj.getmURL()
		});
	}

	public List<HomeInfo> queryObject(int page, int pageSize) {
		// TODO Auto-generated method stub
		JdbcTemplate template = getJdbcTemplate();
		return template.query("select * from house limit " + page*pageSize + "," + pageSize, new HomeInfoRowMapper());
	}

	public List<HomeInfo> queryObjectByColumn(Map<String, String> info,
			int page, int pageSize) {
		// TODO Auto-generated method stub
		if (info.keySet().isEmpty()){
			return queryObject(page, pageSize);
		}
		JdbcTemplate template = getJdbcTemplate();
		StringBuffer sql = new StringBuffer("select * from house where ");
		boolean isFirst = true;
		for (String key : info.keySet()) {
			if (isFirst) {
				isFirst = false;
			} else {
				sql.append(" and ");
			}
			
			sql.append(key + "='" + info.get(key) + "' ");
		}
		sql.append("limit " + page*pageSize + "," + pageSize);
		return template.query(sql.toString(), new HomeInfoRowMapper());
	}


	private class HomeInfoRowMapper implements RowMapper<HomeInfo> {
		public HomeInfo mapRow(ResultSet rs, int index) throws SQLException {
			HomeInfo homeInfo = new HomeInfo.Builder()
						.id(rs.getInt("house_id"))
						.title(rs.getString("title").trim())
						.space(rs.getString("space").trim())
						.style(rs.getString("style").trim())
						.part(rs.getString("part").trim())
						.shape(rs.getString("shape").trim())
						.stuff(rs.getString("stuff").trim())
						.designer(rs.getString("designer").trim())
						.budget(rs.getString("budget").trim())
						.size(rs.getString("size").trim())
						.feel(rs.getString("feel").trim())
						.color(rs.getString("color").trim())
						.url(rs.getString("url").trim())
						.build();
			return homeInfo;
		}
	}

}
