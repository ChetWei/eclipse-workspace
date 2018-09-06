package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Customer;
import service.CustomerService;

/***
 * 客户管理的Action类
 * @author Administrator
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	//模型驱动获取数据
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	//注入业务层的类
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/***
	 * 保存客户的方法 save
	 */
	public String save() {
		System.out.println("Action中的save方法执行了。。。");
		customerService.save(customer);
		return NONE;
		
	}

}
