package daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.CustomerDao;
import domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	//保存一个对象
	@Override
	public void save(Customer customer) {
		System.out.println("Dao的save方法执行了。。。。");
		this.getHibernateTemplate().save(customer);
	}

	//更新一个对象
	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}

	//删除一个对象
	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
		
	}

	//查询单个对象
	@Override
	public Customer findById(Long id) {
		
		return this.getHibernateTemplate().load(Customer.class, id);
	}

	//HQL查询多条记录
	@Override
	public List<Customer> findAllByHQL() {
		
		List<Customer>list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return list;
	}

	//QBC查询多条记录
	@Override
	public List<Customer> findAllByQBC() {
		DetachedCriteria datechedCriteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list =  (List<Customer>) this.getHibernateTemplate().findByCriteria(datechedCriteria);
		return list;
	}

}
