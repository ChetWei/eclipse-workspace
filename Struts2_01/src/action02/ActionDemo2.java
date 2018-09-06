package action02;

import com.opensymphony.xwork2.Action;

/***
 * 二
 * 实现Action接口的类
 * execute()方法定义了五个返回常量
 * SUCCESS :success代表成功
 * NONE:代表页面不跳转
 * ERROR:代表跳转到错误页面
 * INPUT:数据校验的时候跳转的路径
 * LOGIN:用来跳转到登录页面
 *
 */
public class ActionDemo2 implements Action {
	
	@Override
	public String execute() throws Exception {
		System.out.println("ActionDemo2 执行了...");
		return null;
	}
}
