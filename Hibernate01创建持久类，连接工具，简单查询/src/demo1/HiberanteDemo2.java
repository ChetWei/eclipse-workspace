package demo1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateUtils;

public class HiberanteDemo2 {
	
	@Test
	public void demo1() {
		Session session = HibernateUtils.openSession();//不是线程安全的(多个线程之间可以共享)，因此不能定义全局
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCust_name("测试二");
		
		Serializable id = session.save(customer);
		System.out.println(id);
		tx.commit();
		session.close();
		
	}
	
	/***
	 * 查询操作
	 * get 方法
	 *  -> 采用的是立即加载，执行到get()立即发出SQL语句查询
	 *  -> 查询后返回结果是真实对象本身
	 *  -> 没有查询到结果返回的是null
	 *  
	 *  load 方法
	 *  -> 采用的是延迟加载，执行到load()不会发出SQL语句查询，当真正使用这个对象的时候才会发送SQL语句
	 *  ->查询后返回的是代理对象，jacassist-3.18.1-GA.jar 利用javcassist技术产生的代理
	 *  -> 没有查询到结果返回的是 objectNotFoundException
	 */
	@Test
	public void demo2() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		//使用get方法查询
//		Customer customer1 = session.get(Customer.class, 6l);//6l数据是long类型
//		System.out.println(customer1);
//		tx.commit();
//		session.close();
		
		//使用load方法查询
		Customer customer2 = session.load(Customer.class, 5l);
		System.out.println(customer2.getCust_id()); //获取id也不会执行查询
		//System.out.println(customer2); //获取整个对象的内容时会执行查询
		tx.commit();
		session.close();
	}

	/***
	 * 修改操作
	 */
	@Test
	public void demo3() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//先创建对象再修改(覆盖整条记录)
		Customer customer = new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("先创建对象再修改");
		session.update(customer);
		
		
		
		//先查询，再修改(更新记录)
		Customer customer2 = session.get(Customer.class, 2l);
		customer2.setCust_name("先查询再修改");
		session.update(customer2);
		
		tx.commit();
		session.close();
		
	}

	/***
	 * 删除操作
	 */
	@Test
	public void demo4() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//直接创建对象删除
//		Customer customer = new Customer();
//		customer.setCust_id(10l);
//		session.delete(customer);
		
		//先查询到对象，然后删除（推荐）可以级联删除
		Customer customer2 = session.get(Customer.class, 9l);
		session.delete(customer2);
		
		tx.commit();
		session.close();
	}


	/***
	 * 保存或更新
	 */
	@Test
	public void demo5() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();

//		Customer customer = new Customer();
//		customer.setCust_name("张三");
//		session.saveOrUpdate(customer); //不存在-》插入
		
		Customer customer = new Customer();
		customer.setCust_id(4l);
		customer.setCust_name("这是更新操作");
		session.saveOrUpdate(customer); //已经存在的对象则更新
		
		tx.commit();
		session.close();
	}

	
	/***
	 * 查询所有
	 */
	@Test
	public void demo6() {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//接受HQL Hibernate Query Language 面向对象的查询语言
	/*	Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for(Customer customer : list) {
			System.out.println(customer);
		}*/
		
		
		//接受SQL：
		SQLQuery query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = query.list();
		for(Object[] objects:list) {
			System.out.println(Arrays.toString(objects));
		}
		
		
		tx.commit();
		session.close();
	}
}
