package dao;

import java.util.List;

import domain.Customer;

public interface CustomerDao {

	void save(Customer customer);
	
	void update(Customer customer);
	
	void delete(Customer customer);
	
	Customer findById(Long id);
	
	List<Customer> findAllByHQL();
	
	List<Customer>findAllByQBC();
}
