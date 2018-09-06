package interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		System.out.println("登录拦截器执行了。。。。");
		// 判断session中是否有user
		if(existUser == null) {
			//给出提示信息
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("没有登录，无权限访问");
			//回到登录页面
			return actionSupport.LOGIN;
		}else {
			//登录成功
			return invocation.invoke();
		}
		
	}

}
