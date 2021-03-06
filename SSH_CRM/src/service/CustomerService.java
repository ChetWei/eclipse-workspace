package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Customer;
import domain.PageBean;

public interface CustomerService {
	

	
	//保存单个客户
	void save(Customer customer);
	
	//查找一页的数据封装到PageBean
	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria,Integer currentPage,Integer pageSize);

	//查找客户
	Customer findById(Long long1);

	//删除单个客户
	void delete(Customer customer);
	
	//修改客户
	void update(Customer customer);
	
	List<Customer> findAll();
	

}
