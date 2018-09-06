package action02;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;

//struts2的数据封装  二属性驱动：页面中提供表达式方式   可以向多个对象中同时封装数据
public class ActionDemo2 extends ActionSupport{

	//提供一个User对象
	private User user;
	//提供set get方法
	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}
