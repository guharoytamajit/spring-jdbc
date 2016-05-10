package com;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Main {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");

		
IDao dao=(IDao)context.getBean("daoimpl");

		dao.deleteAll();
		dao.create("tamajit", 14, "kolkata");
		dao.create("tamojit", 14, "kolkata");

List<Person> p=dao.fetchAll();
for (Person person : p) {
	System.out.println(person);
}

List<String> st=dao.fetchPersonNames2();
for (String s : st) {
	System.out.println(s);
}
	}

}
