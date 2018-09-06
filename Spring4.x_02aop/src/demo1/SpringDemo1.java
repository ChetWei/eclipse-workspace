package demo1;

import org.junit.jupiter.api.Test;

public class SpringDemo1 {

	//jdk动态代理
	@Test
	public void test1() {
		UserDao userDao = new UserDaoImpl();
		//创建代理
		UserDao proxy = new JdkProxy(userDao).createProxy();
		proxy.save();
	}
}
