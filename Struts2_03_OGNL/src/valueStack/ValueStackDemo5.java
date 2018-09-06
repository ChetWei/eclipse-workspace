package valueStack;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import domain.User;

public class ValueStackDemo5 extends ActionSupport {

	@Override
	public String execute() throws Exception {
		//获得值栈对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		// 向值栈保存一个对象
		User user = new User();
		user.setName("小米");
		user.setPassword("sdfsdas");
		
		valueStack.push(user);
		
		//向值栈保存一个集合
		List<User> list = new ArrayList<User>();
		list.add(new User("张三","qwe"));
		list.add(new User("李四","jojjoe"));
		list.add(new User("王五","asfsf"));
		valueStack.set("list", list);
		
		//向context中保存数据
		ServletActionContext.getRequest().setAttribute("reqName", "reqValue");
		ServletActionContext.getRequest().getSession().setAttribute("sessionName", "sessionValue");
		ServletActionContext.getServletContext().setAttribute("appName", "appValue");
		
		return "demo5";
	}
}
