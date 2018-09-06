package service;

import java.util.List;

import domain.Customer;
import domain.User;

public interface CustomerService {
	//查询所有客户
	List findAll();
	//添加客户
	void add(Customer customer);

}
