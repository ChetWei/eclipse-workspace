package demo3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Junit Spring单元测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo3 {
	
	@Resource(name="productDao")
	private ProductDao productDao;
	
	@Test
	public void test1() {
		productDao.save();
		productDao.add();
		productDao.find();
	}
}
