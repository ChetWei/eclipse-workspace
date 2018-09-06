package demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo1.UserDao;

public class SpringDemo3 {

	/***
	 * 获取注入的属性值
	 */
	@Test
	public void test1() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		Car car = (Car) applicationContext.getBean("car");
		Phone phone = (Phone) applicationContext.getBean("phone");
		System.out.println(phone.toString());
		System.out.println(car.toString());

	}

	/***
	 * 获取注入的对象值
	 */
	@Test
	public void test2() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		Employee employee = (Employee) applicationContext.getBean("employee");
		System.out.println(employee.toString());

	}
	
	@Test
	public void test3() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		Employee employee = (Employee) applicationContext.getBean("employee2");
		System.out.println(employee.toString());
		
	}
	

	
	
}
