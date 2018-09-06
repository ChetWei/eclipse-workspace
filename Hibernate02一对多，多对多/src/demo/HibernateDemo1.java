package demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sun.xml.internal.txw2.TxwException;

import domain.Customer;
import domain.LinkMan;
import utils.HibernateUtils;
/*一对多相关操作*/
public class HibernateDemo1 {
	
	/***
	 * 一对多 插入表的内容
	 */
	@Test
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//1创建两个客户
		Customer customer1 = new Customer();
		customer1.setCust_name("张三");
		Customer customer2 = new Customer();
		customer2.setCust_name("李四");
		
		//2创建三个联系人
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("腾讯客服1");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_name("腾讯客服2");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_name("腾讯客服3");
		
		//3设置关系
		linkMan1.setCustomer(customer1);
		linkMan2.setCustomer(customer1);
		linkMan3.setCustomer(customer2);
		customer1.getLinkMans().add(linkMan1);
		customer1.getLinkMans().add(linkMan2);
		customer2.getLinkMans().add(linkMan3);
		
		//4保存，不使用级联保存，每个对象都进行保存
		session.save(customer1);
		session.save(customer2);
		session.save(linkMan1);
		session.save(linkMan2);
		session.save(linkMan3);
		
		tx.commit();
		
/*		session.close(); //线程锁定的session,不需要关闭,线程关闭则自动关闭   */	
	
	}
	
	
	/***
	 * 一对多级联操作，保存一的一方 级联保存或更新
	 * 保存客户 级联 联系人
	 * Customer.hbm.xml  <set name="linkMans" cascade="save-update">
	 */
	@Test
	public void demo2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("孙悟空");
		
		LinkMan linkMan = new LinkMan();
		linkMan.setLkm_name("猪八戒");
		
		//设置关系
		customer.getLinkMans().add(linkMan);
		linkMan.setCustomer(customer);
		
		
		session.save(customer);

		tx.commit();
	}


	/***
	 * 一对多级联操作 保存多的一方 级联保存更新
	 * LinkMan.hbm.xml <many-to-one name="customer" cascade="save-update" class="domain.Customer" column="lkm_cust_id"/>
	 */
	@Test
	public void demo3() {
		
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("王五");
		
		LinkMan linkMan = new LinkMan();
		linkMan.setLkm_name("京东客服1");
		
		//双向关联
		customer.getLinkMans().add(linkMan);
		linkMan.setCustomer(customer);
		
		//保存多的一方
		session.save(linkMan);
		
		
		tx.commit();
		session.close();
	}


	/***
	 * 测试对象导航
	 */

	public void demo4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("唐僧");
		
		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_name("白骨精1");
		LinkMan linkMan2 = new LinkMan();
		linkMan1.setLkm_name("白骨精2");
		LinkMan linkMan3 = new LinkMan();
		linkMan1.setLkm_name("白骨精3");
		//双方都设置了cascade
		linkMan1.setCustomer(customer);   //发送4条insert语句
		customer.getLinkMans().add(linkMan2); //发送3条insert语句
		customer.getLinkMans().add(linkMan3); //发送1条insert语句
		
		tx.commit();

	}
	
	/***
	 * 级联删除，删除客户，删除关联的联系人   删除一，级联删除多
	 * Customer.hbm.xml cascade="delete"
	 */
	@Test
	public void demo5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//删除客户，级联删除联系人,先查询再删除
		Customer customer = session.get(Customer.class, 2l);
		session.delete(customer);
		
		tx.commit();
	}
	
	/***
	 * 级联删除，删除联系人，删除关联的客户   删除多，级联删除一(基本不用，不合理)
	 * LinkMan.hbm.xml cascade="delete"
	 */
	@Test
	public void demo6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//删除联系人，级联删除客户,先查询再删除
		LinkMan linkMan = session.get(LinkMan.class,5l);
		session.delete(linkMan);
		
		tx.commit();
	}
	
	/***
	 * 区分cascade和inverse的区别
	 */
	@Test
	public void demo7() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//删除联系人，级联删除客户,先查询再删除
		Customer customer = new Customer();
		customer.setCust_name("凤姐啊");
		
		LinkMan linkMan = new LinkMan();
		linkMan.setLkm_name("李留");
		
		//客户关联联系人
		customer.getLinkMans().add(linkMan);
		
		//Customer.hbm.xml  set设置cascade="save-update" inverse="true"
		session.save(customer);//客户会插入到数据库，联系人也会插入，但是外键为null(外键可以为空的情况下，不然报错)
		
		tx.commit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
