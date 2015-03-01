package com.orangexxx.test;

import java.util.Calendar;

public class DaoImpl implements IDao {

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour < 11) {
			return "Good morning " + name;
		} else if (hour < 14) {
			return "Good noon " + name;
		} else {
			return "Good afternoon " + name;
		}
		
	}

}
