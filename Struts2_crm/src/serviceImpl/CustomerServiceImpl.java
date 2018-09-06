package serviceImpl;

import java.util.List;

import dao.CustomerDao;
import dao.UserDao;
import daoImpl.CustomerDaoImpl;
import daoImpl.UserDaoImpl;
import domain.Customer;
import domain.User;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	//查询所有客户
	@Override
	public List findAll() {
		
		CustomerDao customerDao = new CustomerDaoImpl();
		List<Customer> list = customerDao.findAll();
		return list;
	}

	//添加客户
	@Override
	public void add(Customer customer) {
		CustomerDao customerDao = new CustomerDaoImpl();
		customerDao.add(customer);
	}
	
	

}
