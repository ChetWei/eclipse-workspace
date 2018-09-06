package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
		UserService userService = new UserServiceImpl();
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
