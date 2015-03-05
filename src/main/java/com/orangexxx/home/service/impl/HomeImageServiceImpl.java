package com.orangexxx.home.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.orangexxx.home.beans.HomeImage;
import com.orangexxx.home.service.AbstractService;
import com.orangexxx.home.service.HomeImageService;

public class HomeImageServiceImpl extends AbstractService implements
		HomeImageService {

	
	
	
	public static Object getInstance() {
		// TODO Auto-generated method stub
		return getContext().getBean("homeImageService");
	}

	public int insertObject(HomeImage obj) {
		// TODO Auto-generated method stub
		JdbcTemplate template = getJdbcTemplate();
		template.update("insert into img (house_id, url, info) values (?,?,?)",
				new Object[] {
				obj.getmHomeID(),
				obj.getmURL(),
				obj.getmInfo()
		});
		return template.queryForInt("select @@identity");
	}

	public void deleteObject(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate template = getJdbcTemplate();
		template.update("delete from img where image_id =" + id);

	}

	public void updateObject(HomeImage obj, int id) {
		// TODO Auto-generated method stub
		JdbcTemplate template = getJdbcTemplate();
		template.update("update img set house_id = ?, info = ?, url = ? where image_id = " + id, new Object[]{
				obj.getmHomeID(),
				obj.getmInfo(),
				obj.getmURL(),
		});

	}

	public List<HomeImage> queryObject(int page, int pageSize) {
		// TODO Auto-generated method stub
		JdbcTemplate template = getJdbcTemplate();
		return template.query("select * from img limit " + page*pageSize + "," + pageSize, new HomeImageRowMapper());
		
	}

	public List<HomeImage> queryObjectByColumn(Map<String, String> info,
			int page, int pageSize) {
		// TODO Auto-generated method stub
		if (info.keySet().isEmpty()) {
			return queryObject(page, pageSize);
		}
		JdbcTemplate template = getJdbcTemplate();
		StringBuffer sql = new StringBuffer("select * from img where ");
		boolean isFirst = true;
		for (String key : info.keySet()) {
			if (isFirst) {
				isFirst = false;
			} else {
				sql.append(" and ");
			}
			sql.append(key + " = '" + info.get(key) + "' ");
		}
		sql.append("limit " + page*pageSize + "," + pageSize);
		return template.query(sql.toString(), new HomeImageRowMapper());
	}

	private class HomeImageRowMapper implements RowMapper<HomeImage>{
		public HomeImage mapRow(ResultSet rs, int index) throws SQLException {
			HomeImage homeImage = new HomeImage.Builder()
						.id(rs.getInt("image_id"))
						.homeID(rs.getInt("house_id"))
						.url(rs.getString("url").trim())
						.info(rs.getString("info").trim())
						.build();
			
			return homeImage;
		}
	}
}
