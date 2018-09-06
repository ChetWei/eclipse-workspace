package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Customer;

public interface CustomerDao {

	//保存单个客户
	void save(Customer customer);

	//查找记录条数
	Long getCount(DetachedCriteria detachedCriteria);
	
	//查询当前页的所有客户
	List fingByPage(DetachedCriteria detachedCriteria,int begin,int pageSize);

	Customer findById(Long cust_id);

	//删除单个客户
	void delete(Customer customer);
	
	//修改客户
	void update(Customer customer);

	//查询所有客户
	List<Customer> finAll();
}