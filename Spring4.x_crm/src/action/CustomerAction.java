package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Customer;
import service.CustomerService;
import serviceImpl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//使用模型驱动获取数据
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	/***
	 *列出所有客户
	 */
	public String findAll() {
		//利用spring工厂获取实例
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		
		List<Customer> list = customerService.findAll();
		//将数据放到web作用域
/*		//利用servlet原生方法
		ServletActionContext.getRequest().setAttribute("list", list);*/
		
		//存入值栈
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("list", list);
		
		return  "findAll"; //返回字符串，在action中配置跳转路径
	}
	
	/***
	 * 进入添加客户页面
	 */
	
	public String enterAdd() {
		return "enterAdd";
	}
	
	/***
	 * 添加客户动作
	 */
	public String add() {
		//获取数据 封装数据,模型驱动
		//调用业务层
		CustomerService customerService = new CustomerServiceImpl();
		customerService.add(customer);
		
		//通过返回值页面跳转到客户列表
		return "addSuccess";
	}


	
}
