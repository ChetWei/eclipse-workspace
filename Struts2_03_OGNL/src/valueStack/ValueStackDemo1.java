package valueStack;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackDemo1 extends ActionSupport {

	@Override
	public String execute() throws Exception {
		//获得值栈
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		return NONE;
	}
	
}
