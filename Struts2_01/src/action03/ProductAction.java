package action03;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	public String find() {
		System.out.println("商品查询操作。。。。");
		return NONE;
	}
	public String update() {
		System.out.println("商品更新操作。。。。");
		return NONE;
	}
	public String delete() {
		System.out.println("商品删除操作。。。");
		return NONE;
	}
	public String save() {
		System.out.println("商品保存操作。。。");
		return NONE;
	}
	
}
