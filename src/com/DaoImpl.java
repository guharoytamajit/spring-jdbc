package com;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation=Propagation.REQUIRED,readOnly=true)	
public class DaoImpl extends JdbcDaoSupport implements IDao {

//JdbcTemplate jdbcTemplate;
//public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//	this.jdbcTemplate = jdbcTemplate;
//}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)	
public void	create(String name,int age,String location)
	{

	getJdbcTemplate().update("insert into Person values(?,?,?) ",name,age,location);
		
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)	
public void delete(String name){
	
	getJdbcTemplate().update("delete from person where name=?",new Object[]{name});
}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)	
public void deleteAll()
{
	
	getJdbcTemplate().update("delete from person");
}
public Person fetch(String name){

	//return jt.queryForObject("select * from person where name=?",new Object[] {name}, new PersonRowMapper());
	return getJdbcTemplate().queryForObject("select * from person where name=?",new Object[] {name}, new RowMapper<Person>(){

		@Override
		public Person mapRow(ResultSet rs, int num) throws SQLException {
		return new Person(rs.getString(1),rs.getInt(2),rs.getString(3));
		}});
	
}
public List<Person> fetchAll(){
	return getJdbcTemplate().query("select * from person ", new RowMapperResultSetExtractor(new PersonRowMapper()) );
}
public List<String> fetchPersonNames() {
return	getJdbcTemplate().query("select name from person ",new RowMapperResultSetExtractor(new RowMapper() {

		@Override
		public String mapRow(ResultSet rs, int arg1) throws SQLException {
			
			return rs.getString(1) ;
		}
	}));
	
}
public List<String> fetchPersonNames2() throws SQLException{
	List<String> result=new ArrayList<String>();
	Connection con = getJdbcTemplate().getDataSource().getConnection();
	Statement statement = con.createStatement();
	ResultSet rs = statement.executeQuery("select name from person ");
	while(rs.next()){
		result.add(rs.getString(1));
	}
	return result;
}

}
