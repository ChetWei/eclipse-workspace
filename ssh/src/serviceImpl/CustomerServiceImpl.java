package serviceImpl;

import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import domain.Customer;
import service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {

	//注入dao
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("service中的save方法执行了。。"+customer);
		customerDao.save(customer);
	}
	
	
}
