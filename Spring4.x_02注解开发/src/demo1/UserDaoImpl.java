package demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("userDao") //相当于<bean id="userDao" class="demo1.UserDaoImpl"/>
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Value("张三") //注解，属性注入，不需要set方法
	private String name;
	


	@Override
	public void save() {
		System.out.println("UserDaoImpl 的save方法执行了"+name);
		
	}

}
