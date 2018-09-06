package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.CustomerDao;
import domain.Customer;
import utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List findAll() {
		System.out.println("CustomerDaoImpl 的findAll方法执行了。。。");
		return null;
	}

	@Override
	public void add(Customer customer) {
		System.out.println("CustomerDaoImpl 的add方法执行了。。。");
	}

}
