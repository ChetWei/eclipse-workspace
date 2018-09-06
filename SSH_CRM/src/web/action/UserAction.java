package web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;
import service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	//模型驱动，获取数据
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	//注入service
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	/***
	 * 用户注册 regist
	 */
	public String regist() {
		userService.regist(user);
		return LOGIN;
		
	}
	
	/***
	 * 用户登录 login
	 */
	public String login() {
		User existUser = userService.login(user);
		if(existUser == null) {
			//登录失败
			this.addActionError("用户名或密码错误");
			return LOGIN;
		}else {
			//登录成功
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}
		
		
		
	}

}
