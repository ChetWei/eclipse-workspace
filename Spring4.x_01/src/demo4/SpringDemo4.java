package demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringDemo4 {

	//SpEL表达式
	
	@Test
	public void test1() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		Book book = (Book) applicationContext.getBean("book");
		
		System.out.println(book.toString());
		
	}
	@Test
	public void test2() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		Book book = (Book) applicationContext.getBean("book2");
		
		System.out.println(book.toString());
		
	}
	@Test
	public void test3() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		Book book = (Book) applicationContext.getBean("book3");
		
		System.out.println(book.toString());
		
	}
}
