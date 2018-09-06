package demo3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {

	//注解+xml
	@Test
	public void test1() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService studentService = (StudentService) classPathXmlApplicationContext.getBean("studentService");
		studentService.save();
	
	}
}
