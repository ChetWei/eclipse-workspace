package demo1;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {

	//Spring的注解开发》普通属性注入
	
	@Test
	public void test1() {
		
		ApplicationContext applicationContext = new	ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}
	
	//Spring的注解方式 》 对象注入
	@Test
	public void test2() {
		
		ApplicationContext applicationContext = new	ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.save();
	}
	
}
