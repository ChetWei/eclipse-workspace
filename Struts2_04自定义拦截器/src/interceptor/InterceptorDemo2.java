package interceptor;

import org.eclipse.jdt.internal.compiler.ast.Invocation;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptorDemo2 extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("InterceptorDemo2执行了。。。");
		String obj = invocation.invoke();
		System.out.println("InterceptorDemo2执行结果了。。。");
		return obj;
	}

}
