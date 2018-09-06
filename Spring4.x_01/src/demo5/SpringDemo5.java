
package demo5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo4.Book;

/***
 * 集合类型的属性注入
 * @author Administrator
 *
 */
public class SpringDemo5 {

	@Test
	public void test1() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean");
		
		System.out.println(collectionBean.toString());
		
	}
	@Test
	public void test2() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean2");
		
		System.out.println(collectionBean.toString());
		
	}
	@Test
	public void test3() {
		//1 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2 用工厂获取实例
		CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean3");
		
		System.out.println(collectionBean.toString());
		
	}
}
