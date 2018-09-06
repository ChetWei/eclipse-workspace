package action02;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;

//模型驱动 （最常用） 	缺点：只能同时向一个对象中封装数据。
public class ActionDemo3  extends ActionSupport implements ModelDriven<User>{

	//模型驱动使用的对象，前提必须手动提供对象的实例
	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}



	
	
}
