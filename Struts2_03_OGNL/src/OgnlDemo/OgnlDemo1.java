package OgnlDemo;

import org.junit.jupiter.api.Test;

import domain.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlDemo1  {

	/***
	 * OGNL调用对象的方法
	 * @throws OgnlException 
	 */
	@Test
	public void demo1() throws OgnlException {
		//获得context
		OgnlContext context = new OgnlContext();
		//获得根对象
		Object root = context.getRoot();
		//执行表达式
		Object value = Ognl.getValue("'helloworld'.length()", context, root);
		System.out.println(value);
	}
	
	/***
	 * OGNL访问对象的静态方法
	 * @throws OgnlException 
	 */
	@Test
	public void demo2() throws OgnlException {
		//获得context
		OgnlContext context = new OgnlContext();
		//获得根对象
		Object root = context.getRoot();
		//执行表达式@类名@方法名
		Object value = Ognl.getValue("@java.lang.Math@random()", context, root);
		System.out.println(value);
	}
	
	/***
	 * 访问根中的的数据
	 */
	@Test
	public void demo3() throws OgnlException {
		
		//获得context
		OgnlContext context = new OgnlContext();
		
		User user = new User("a","123");
		context.setRoot(user);
		
		//获得根对象
		Object root = context.getRoot();

		Object name = Ognl.getValue("name", context,root);
		System.out.println(name);
		
	}
	
	
	/***
	 * 访问context中的数据
	 */
	@Test
	public void demo4() throws OgnlException {
		
		//获得context
		OgnlContext context = new OgnlContext();
		//获得根对象
		Object root = context.getRoot();
		
		//向context中存入数据
		context.put("name", "张三");
		
		Object value = Ognl.getValue("#name", context,root);
		System.out.println(value);
		
	}
	
	
}
