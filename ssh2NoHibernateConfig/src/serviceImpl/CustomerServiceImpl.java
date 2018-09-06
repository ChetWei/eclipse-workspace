package serviceImpl;

import java.util.List;

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

	@Override
	public void update(Customer customer) {
		System.out.println("service中的update方法执行了。。"+customer);
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		System.out.println("service中的delete方法执行了。。"+customer);
		customerDao.delete(customer);
		
	}

	@Override
	public Customer findById(Long id) {
		System.out.println("service中的查找单个方法执行了。。");
		return customerDao.findById(id);
	}

	@Override
	public List<Customer> findAllByHQL() {
		System.out.println("service中的查找所有方法执行了。。");
		return customerDao.findAllByHQL();
	}

	@Override
	public List<Customer> findAllByQBC() {
		
		System.out.println("service中的查找所有方法执行了。。");
		return customerDao.findAllByQBC();
	}
	
	
}
