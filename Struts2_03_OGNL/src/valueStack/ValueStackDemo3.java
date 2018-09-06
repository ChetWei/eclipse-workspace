package valueStack;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;
//值栈的操作
public class ValueStackDemo3 extends ActionSupport {
	//向值栈存入数据方式一
	private User user ;

	public User getUser() {
		return user;
	}
	@Override
	public String execute() throws Exception {
		user = new User("张三","231");
		return "saveValue";
	}
	
}
