package valueStack;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import domain.User;
/***
 * 操作值栈方式二：调用值栈中的方法实现
 */
public class ValueStackDemo4 extends ActionSupport {

	@Override
	public String execute() throws Exception {
		//向值栈中保存数据
		//1获取值栈对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//2使用push(obj)  set(String key,obj)
		User user = new User("张三","123");
		valueStack.push(user); //放入栈顶
		
		valueStack.set("keyname", "keyvalue");//进栈，也是放入栈顶
		
		
		return "saveValue";
	}
			
}
