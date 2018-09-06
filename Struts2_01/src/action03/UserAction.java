package action03;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	public String find() {
		System.out.println("用户查询操作。。。。");
		return NONE;
	}
	public String update() {
		System.out.println("用户更新操作。。。。");
		return NONE;
	}
	public String delete() {
		System.out.println("用户删除操作。。。");
		return NONE;
	}
	public String save() {
		System.out.println("用户保存操作。。。");
		return NONE;
	}
	
}
