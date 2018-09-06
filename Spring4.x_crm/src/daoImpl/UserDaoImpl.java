package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.UserDao;
import domain.User;
import utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(User user) {
		System.out.println("UserDaoImpl的login方法执行了");
		return null;
	}

}
