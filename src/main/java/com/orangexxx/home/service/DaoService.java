package com.orangexxx.home.service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface DaoService<T> {
	
	
	public int insertObject(T obj);
	
	public void deleteObject(int id);
	
	public void updateObject(T obj, int id);
	
	public List<T> queryObject(int page, int pageSize);
	
	public List<T> queryObjectByColumn(Map<String, String> info, int page, int pageSize);
	
}
