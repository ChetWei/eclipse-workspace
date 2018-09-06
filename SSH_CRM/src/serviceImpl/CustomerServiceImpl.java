package serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import domain.Customer;
import domain.PageBean;
import service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	//*****对象注入******
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	//保存单个客户
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}


	// 查询一页的的数据
	@Override
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		PageBean<Customer> pageBean = new PageBean();
		//封装当前页
		pageBean.setCurrentPage(currentPage);
		//封装每页显示记录数
		pageBean.setPageSize(pageSize);
		//封装总记录数
		Long totalCount = customerDao.getCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		Double num = Math.ceil(totalCount.doubleValue()/pageSize);
		pageBean.setTotalPage(num.longValue());
		//封装每页显示数据的集合
		Integer begin = (currentPage-1) * pageSize;
		List list = customerDao.fingByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}


	//查找客户
	@Override
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}


	//删除单个客户
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}

	//修改客户
	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}


	//查询所有客户
	@Override
	public List<Customer> findAll() {
		List list = customerDao.finAll();
		return list;
	}






	

}
