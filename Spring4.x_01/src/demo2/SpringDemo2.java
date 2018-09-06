package demo2;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {

	@Test
	public void test1() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) classPathXmlApplicationContext.getBean("customerDao");
		customerDao.save();
		classPathXmlApplicationContext.close();
	}
}
