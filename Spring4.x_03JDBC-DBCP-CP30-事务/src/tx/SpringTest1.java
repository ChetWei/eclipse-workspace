package tx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/***
 * 事务处理
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:tx.xml")  //第一种使用事务处理模块,编程式事务管理需要手动编写代码
//@ContextConfiguration("classpath:tx2.xml")  //第二种 通过配置文件实现（AOP）
@ContextConfiguration("classpath:tx3.xml")  //第三种 通过注解实现
public class SpringTest1 {

	//注解注入
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("李四", "魏魏魏", 1000d);
	}
}
