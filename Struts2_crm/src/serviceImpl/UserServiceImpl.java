package serviceImpl;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	//用户登录查询
	@Override
	public User login(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.login(user);
	}



}
