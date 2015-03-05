package com.orangexxx.home.test.database;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;



public class SQLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource datasource= (DataSource) context.getBean("dataSource");
		
		JdbcTemplate template=new JdbcTemplate(datasource);
		template.update("insert into img(url, text) values(?,?)", new Object[]{
				"www.orangexxx.com",
				"xiayang"
		},new int[] {
				java.sql.Types.VARCHAR,
				java.sql.Types.VARCHAR
		});
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "");
//			System.out.println("ok!");
//		}catch(ClassNotFoundException e1){
//			e1.printStackTrace();
//		}catch(SQLException e2) {
//			e2.printStackTrace();
//		}
		
	}

}
