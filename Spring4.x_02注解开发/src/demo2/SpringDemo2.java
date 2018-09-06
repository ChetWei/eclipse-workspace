package demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {

	//bean的生命周期注解
	@Test
	public void test1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		customerService.save();
		applicationContext.close();
	}
	//bean的作用范围注解
	@Test
	public void test2() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService1 = (CustomerService) applicationContext.getBean("customerService");
		customerService1.save();
		
		
		CustomerService customerService2 = (CustomerService) applicationContext.getBean("customerService");
		customerService2.save();
		


	}
}
