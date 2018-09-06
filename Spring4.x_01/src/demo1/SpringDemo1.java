package demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {

	/***
	 * 传统方式的业务实现调用
	 */
	@Test
	public void test1() {
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.setName("张三");
		userDao.save();
	}
	
	/***
	 * Spring方式实现业务
	 */
	@Test
	public void test2() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
