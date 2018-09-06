package action03;

import com.opensymphony.xwork2.ActionSupport;

public class Customer extends ActionSupport {

	public String find() {
		System.out.println("客户查询操作。。。。");
		return NONE;
	}
	public String update() {
		System.out.println("客户更新操作。。。。");
		return NONE;
	}
	public String delete() {
		System.out.println("客户删除操作。。。");
		return NONE;
	}
	public String save() {
		System.out.println("客户保存操作。。。");
		return NONE;
	}
	
}
