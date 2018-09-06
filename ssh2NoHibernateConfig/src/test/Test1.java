package test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.Customer;
import service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test1 {

	@Resource(name="customerService")
	private CustomerService customerService;
	
	@Test
	public void demo1() {
		List<Customer> list = customerService.findAllByHQL();
		for(Customer customer:list) {
			System.out.println(customer);
		}
	}
	
	@Test
	public void demo2() {
		Customer customer = customerService.findById(1l);
		customerService.delete(customer);
	}
}
