package action;

import com.opensymphony.xwork2.ActionSupport;

public class actionDemo1 extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("ActionDemo1执行了");
		return NONE;
	}
	
}
