package demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import domain.Customer;
import utils.HibernateUtils;

/*QBC查询*/
public class HibernateDemo2 {

	//1简单查询
	@Test
	public void test1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//获取criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> customer_list = criteria.list();
		
		for(Customer customer: customer_list) {
			System.out.println(customer);
		}
		tx.commit();
	}
	
	//2排序查询
	@Test
	public void test2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		//criteria.addOrder(Order.asc("cust_id"));
		criteria.addOrder(Order.desc("cust_id")); //降序
		
		List<Customer> customer_list = criteria.list();
		
		for(Customer customer: customer_list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	//3.分页查询
	@Test
	public void test3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(2);//偏移量
		criteria.setMaxResults(10);//每页显示量
		List<Customer> customer_list = criteria.list();
		
		for(Customer customer: customer_list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	//4.条件查询
	@Test
	public void test4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//设置条件
	/*			= eq
				> gt
				>=
				<
				<=
				!=
				like
				in
				and
				or*/
		Criteria criteria = session.createCriteria(Customer.class);
		//添加条件
		criteria.add(Restrictions.eq("cust_source", "qq"));
		criteria.add(Restrictions.like("cust_name","客%"));
		List<Customer> customer_list = criteria.list();
		
		for(Customer customer: customer_list) {
			System.out.println(customer);
		}
		
		
		tx.commit();
	}
	
	//5统计查询
	@Test
	public void test5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		/*add 普通条件 where后面的条件
		addOrder 排序
		setProjecion 聚合函数和goup by having*/
		criteria.setProjection(Projections.rowCount());
		Long num = (Long) criteria.uniqueResult();
		System.out.println(num);
		
		tx.commit();
	}
	
	//5离线条件查询
	@Test
	public void test6() {
		
		//不使用session构造条件
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class); //离线查询对象
		detachedCriteria.add(Restrictions.like("cust_name","客%")); //离线查询条件
		
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//将之前的条件与session关联
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
	
		List<Customer> customer_list = criteria.list();
		
		for(Customer customer: customer_list) {
			System.out.println(customer);
		}

		tx.commit();
	}
}
