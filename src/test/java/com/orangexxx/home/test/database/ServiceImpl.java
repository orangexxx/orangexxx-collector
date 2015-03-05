package com.orangexxx.home.test.database;

public class ServiceImpl implements IService {

	private IDao dao;
	public void service(String name) {
		// TODO Auto-generated method stub
		System.out.println(dao.sayHello(name));
	}
	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
