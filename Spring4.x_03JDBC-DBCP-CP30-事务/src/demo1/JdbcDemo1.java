package demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class JdbcDemo1 {
	
	//jdbc模板的使用类似于dbutils
	@Test
	public void test1() {
		//创建连接池
		DriverManagerDataSource dataSource =  new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring03");
		dataSource.setUsername("root");
		dataSource.setPassword("110811");
		//创建jdbc模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into account values (null,?,?)","喂喂喂",2000d);
	
	}
	
	
	
	
	
}
