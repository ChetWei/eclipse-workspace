package demo1;

public class OrderDao {

	public String save() {
		System.out.println("保存订单操作");
		return "save方法的返回值";
	}
	
	public void add() {
		System.out.println("添加订单操作");
	}
	
	public void delete() {
		System.out.println("删除订单操作");
	}
}
