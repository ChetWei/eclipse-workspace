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
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> customer_list = session.createQuery("from Customer").list();		
		
		tx.commit();
		return customer_list;
	}

	@Override
	public void add(Customer customer) {
		// 添加一个客户
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.save(customer); //直接保存一个客户对象
		
		tx.commit();
	}

}
