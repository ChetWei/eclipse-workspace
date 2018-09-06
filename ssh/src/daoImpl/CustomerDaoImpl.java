package daoImpl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.CustomerDao;
import domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		System.out.println("Dao的save方法执行了。。。。");
		this.getHibernateTemplate().save(customer);
	}

}
