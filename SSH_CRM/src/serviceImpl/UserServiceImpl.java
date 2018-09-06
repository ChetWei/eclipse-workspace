package serviceImpl;

import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.User;
import service.UserService;
import utils.MD5Utils;

@Transactional //事务管理注解
public class UserServiceImpl implements UserService {

	//注入DAO
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	// 业务层注册用户
	@Override
	public void regist(User user) {
		//对密码进行加密
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		//调用DAO
		userDao.save(user);
	}


	//用户登录
	@Override
	public User login(User user) {
		//对密码进行加密然后核对,用户状态校验
		String password = user.getUser_password();
		
		
		user.setUser_password(MD5Utils.md5(password)); //加密
		
		User existUser = userDao.login(user);   //调用Dao的login,查询到存在用户的所有信息
		
		if(existUser != null) {
			if(existUser.getUser_state().equals("1")) {
				return existUser;
			}
		}
		return null;
	}

}
