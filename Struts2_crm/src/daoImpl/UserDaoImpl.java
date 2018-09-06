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
		//用户登录查询
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		 Query query = session.createQuery("from User where user_code= ? and user_password= ?");
		 query.setParameter(0, user.getUser_code());
		 query.setParameter(1, user.getUser_password());
		 List<User> list = query.list();
		 if(list.size() > 0 ) {
			 //查询到对象返回第一个
			 return list.get(0);
		 }
		 
		tx.commit();
		return null;
	}

}
