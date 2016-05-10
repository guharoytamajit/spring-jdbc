package com;

import java.sql.SQLException;
import java.util.List;

public interface IDao {

	public void create(String name, int age, String location);

	public void delete(String name);

	public void deleteAll();

	public Person fetch(String name);

	public List<Person> fetchAll();

	public List<String> fetchPersonNames();

	public List<String> fetchPersonNames2() throws SQLException;
}
