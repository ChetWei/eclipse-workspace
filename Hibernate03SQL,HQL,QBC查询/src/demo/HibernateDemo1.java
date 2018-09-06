package demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import com.mysql.fabric.xmlrpc.base.Array;

import domain.Customer;
import domain.LinkMan;
import utils.HibernateUtils;

/*HQL查询*/
public class HibernateDemo1 {

	//1初始化一些数据
	@Test
	public void test1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCust_name("客户pp");
		for(int i =0;i<=10;i++) {
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("联系人"+i);
			
			linkMan.setCustomer(customer);
			customer.getLinkMans().add(linkMan);
			
			session.save(linkMan);
			
		}
		session.save(customer);
		
		
		tx.commit();
	}

	//2HQL简单查询 不支持 '*'
	@Test
	public void test2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//简单的查询
		Query query = session.createQuery("from Customer");
		List<Customer> customer_list = query.list();
		for(Customer customer : customer_list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}


	//3别名查询
	@Test
	public void test3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//简单的查询
		Query query = session.createQuery("from Customer c");
		List<Customer> customer_list = query.list();
		for(Customer customer : customer_list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}

	//4排序查询
	@Test
	public void test4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//简单的查询
		Query query = session.createQuery("from Customer order by cust_id desc"); //倒序desc 顺序asc默认
		List<Customer> customer_list = query.list();
		for(Customer customer : customer_list) {
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	//5投影查询（部分属性查询）
	@Test
	public void test5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
/*		//单个属性
		List<Object> list = session.createQuery("select c.cust_name from Customer c").list();
		for(Object obj:list) {
			System.out.println(obj);
		}
		//多个属性
		List<Object[]> list2 = session.createQuery("select c.cust_name,c.cust_source from Customer c").list();
		for(Object obj[] :list2) {
			System.out.println(Arrays.toString(obj));
		}*/
		
		//将属性封装到对象中,在实体中实现构造方法，带有要查询的属性参数
		List<Customer> customer_list = session.createQuery("select new Customer(cust_name,cust_source) from Customer ").list();
		for(Customer customer : customer_list) {
			System.out.println(customer);
		}

		tx.commit();
	}



	//6分页查询
	@Test
	public void test6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//分页查询
		Query query = session.createQuery("from LinkMan"); 
		query.setFirstResult(10);//偏移量
		query.setMaxResults(10);//每页显示
		List<LinkMan> linkMan_list = query.list();
		for(LinkMan linkMan : linkMan_list) {
			System.out.println(linkMan);
		}
		
		tx.commit();
	}

	//7分组统计查询
	@Test
	public void test7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//聚合函数的使用
		Object obj = session.createQuery("select count(*) from LinkMan").uniqueResult(); 
		System.out.println("联系人共计:"+obj);
		
		//分组统计
		List<Object []> list =session.createQuery("select cust_source,count(*) from Customer group by cust_source").list();
		for(Object[] object : list) {
			System.out.println(Arrays.toString(object));
		}
		
		tx.commit();
	}

	
	//8多表连接查询
	
	@Test
	public void test8() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//内连接，返回的是数组集合
		List<Object[]> list = session.createQuery("from Customer c inner join c.linkMans").list();
		for(Object[] obj :list) {
			System.out.println(Arrays.toString(obj));
		}
		//返回的是一边的对象集合,迫切连接
		List<Customer> list2 = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans").list();
		for(Customer customer: list2) {
			System.out.println(customer);
		}
		
		tx.commit();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
