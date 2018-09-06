package dao;

import java.util.List;

import domain.Customer;

public interface CustomerDao {

	//查询所有客户
	List findAll();
	
	//添加客户
	void add(Customer customer);
}
