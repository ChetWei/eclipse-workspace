package serviceImpl;



import dao.UserDao;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	//依赖注入
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	//用户登录查询
	@Override
	public User login(User user) {
		userDao.login(user);
		
		return null;
	}



}
