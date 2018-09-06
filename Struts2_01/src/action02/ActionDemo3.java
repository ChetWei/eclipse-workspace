package action02;

import com.opensymphony.xwork2.ActionSupport;

/***
 * 三
 * 继承ActionSupport类（推荐）
 * ActionSupport类本身就已经实现了Action接口
 * 提供了数据校验，国际化等一系列操作
 */
public class ActionDemo3 extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		System.out.println("ActionDemo3执行了。。。");
		return NONE;
	}
}
