package demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import domain.Customer;
import utils.HibernateUtils;

/*SQL查询*/
public class HibernateDemo3 {

	@Test
	public void test1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//1以数组方式显示
/*		SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
		List<Object[]> obj_list = sqlQuery.list();
		for(Object[] obj:obj_list) {
			System.out.println(Arrays.toString(obj));
		}
		*/
		//2保存对象列表
		SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
		sqlQuery.addEntity(Customer.class);
		List<Customer> customer_list = sqlQuery.list();
		for(Customer customer : customer_list) {
			System.out.println(customer);
		}
		
		
		
		
		tx.commit();
	}
}
