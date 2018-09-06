package crudDemo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo2.Account;
import demo2.MyRowMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demo1 {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	//保存操作
	@Test
	public void test1() {
		jdbcTemplate.update("insert into account values(null,?,?)", "魏魏魏",8000);
	}
	
	//修改操作
	@Test
	public void test2() {
		jdbcTemplate.update("update account set name= ?  where id = ?", "vvvvv",1);
	}
	
	//删除操作
	@Test
	public void test3() {
		jdbcTemplate.update("delete from account where id = ?", 1);
	}
	
	//查询操作,单个属性
	@Test
	public void test4() {
		String name = jdbcTemplate.queryForObject("select name from account where id = ?", String.class,2);
		System.out.println(name);
	}
	
	//统计查询
	@Test
	public void test5() {
		Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
		System.out.println(count);
	}
	
	//查询返回对象或集合
	@Test
	public void test6() {
		Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new MyRowMapper(),4);
		System.out.println(account);
	}
	
	//查询多条记录
	@Test
	public void test7() {
		List<Account> list = (List<Account>) jdbcTemplate.query("select * from account", new MyRowMapper());
		for(Account account: list) {
			System.out.println(account);
		}
	}
}












