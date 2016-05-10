
package com;import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int num) throws SQLException {
	Person p=new Person();
	p.setName(rs.getString(1));
	p.setAge(rs.getInt(2));
	p.setLocation(rs.getString(3));
	return p;
	}

}
