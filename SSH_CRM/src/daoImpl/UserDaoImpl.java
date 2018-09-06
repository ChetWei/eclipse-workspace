package daoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.UserDao;
import domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	//需要在spring配置SessionFactory注入
	
	
	//用户注册保存用户
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}

	//用户登录
	@Override
	public User login(User user) {
		
		String hql = "from domain.User u where u.user_code= ?0 and u.user_password = ?1";

		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUser_code(),user.getUser_password());
	
		if(list.size() > 0 ) {
		User existUser = list.get(0);
		return existUser;
	}

	return null;
	}

}
