package action;

public class StrutsDemo1 {

	/***
	 * 提供默认的执行方法
	 */
	public String execute() {
		System.out.println("StrutsDemo1中的execute执行了");
		
		return "success";
	}
}
