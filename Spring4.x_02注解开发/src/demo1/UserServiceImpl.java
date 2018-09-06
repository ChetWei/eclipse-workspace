package demo1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//注解开发   》》》 对象属性的注入
@Component("userService")
public class UserServiceImpl implements UserService {

	/*@Qualifier(value="userDao")  //设置按照名称完成属性注入(默认不设置是按照类型完成属性注入)
	@Autowired  //对象注入*/	
	
	@Resource(name="userDao")//直接按名称完成属性注入（开发常用）
	private UserDao userDao;
	
	@Override
	public void save() {
		userDao.save();
	}

}
