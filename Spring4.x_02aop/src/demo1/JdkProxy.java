package demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

	//将要被增强的对象传递到代理中
	private UserDao userDao;

	public JdkProxy(UserDao userDao) {
		this.userDao = userDao;
	}

	/***
	 *产生UserDao代理的方法
	 */
	public UserDao createProxy() {
		UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(), this);
		return userDaoProxy;
	}
	
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {
		//判断方法名是不是要增强的方法
		if("save".equals(method.getName())) {
			//
			System.out.println("==========实现权限校验==========");
		}
		return method.invoke(userDao, arg);
	}

}
