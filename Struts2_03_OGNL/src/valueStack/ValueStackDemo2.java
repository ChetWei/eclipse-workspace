package valueStack;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackDemo2 extends ActionSupport {

	@Override
	public String execute() throws Exception {
		//获得值栈的两种方式
		
		//1
		ValueStack valueStack1 = ActionContext.getContext().getValueStack();
		
		//2
		ValueStack valueStack2 = (ValueStack) ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		
		System.out.println(valueStack1==valueStack2);
		
		return NONE;
	}
}
