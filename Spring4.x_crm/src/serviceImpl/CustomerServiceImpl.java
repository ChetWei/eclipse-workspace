package serviceImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CustomerDao;
import dao.UserDao;
import daoImpl.CustomerDaoImpl;
import daoImpl.UserDaoImpl;
import domain.Customer;
import domain.User;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	//依赖注入 
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	//查询所有客户
	@Override
	public List findAll() {
	
		

		return null;
	}

	//添加客户
	@Override
	public void add(Customer customer) {
		
	}
	
	

}
