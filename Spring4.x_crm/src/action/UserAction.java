package action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.CustomerDao;
import domain.User;
import service.UserService;
import serviceImpl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	//1 接受数据
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	/***
	 * 用户登录方法
	 */
	public String login() {
		//创建一个工厂类，保存在ServletContext中
		ServletContext servletContext = ServletActionContext.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		//不需要没来一个请求创建新的实例，直接获取
		UserService userService = (UserService) webApplicationContext.getBean("userService");
		
		User existUser = userService.login(user);
		//根据验证结果页面跳转
		if(existUser == null) {
			//在值栈中添加错误信息
			this.addActionError("用户名或密码错误");
			return LOGIN;
		}else {
			System.out.println(user);
			//登录成功，在session中放入数据
			//ActionContext.getContext().getSession().put("existUser", existUser);
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return SUCCESS;
		} 
		
	}
	
}
