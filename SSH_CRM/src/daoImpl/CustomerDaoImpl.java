package daoImpl;



import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.CustomerDao;
import domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {


	
	//保存单个客户
	@Override
	public void save(Customer customer) {
		
		Serializable save = this.getHibernateTemplate().save(customer);
		
	}
	
	
	//查询总记录数
	@Override
	public Long getCount(DetachedCriteria detachedCriteria) {
		
		detachedCriteria.setProjection(Projections.rowCount()); //设置条件count(*)
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0) {
			return list.get(0).longValue();
		}
		return null;
	}

	//分页查询客户
	@Override
	public List fingByPage(DetachedCriteria detachedCriteria, int begin, int pageSize) {
		detachedCriteria.setProjection(null); //清空条件,避免出错
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
		
		return list;
	}


	//查找单个客户
	@Override
	public Customer findById(Long cust_id) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from domain.Customer c where c.cust_id = ?0", cust_id);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}


	//删除单个客户
	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	//更新客户
	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}


	@Override
	public List<Customer> finAll() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}




	
	





}
