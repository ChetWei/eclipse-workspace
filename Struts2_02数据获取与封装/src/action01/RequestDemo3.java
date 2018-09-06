package action01;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
//三  接口注入方式
public class RequestDemo3 extends ActionSupport implements ServletRequestAware,ServletContextAware{
	
	private HttpServletRequest request;
	private ServletContext context;

	@Override
	public String execute() throws Exception {
		//1接收数据
		System.out.println("action3");
		Map<String, String[]> map = request.getParameterMap();
		for(String key: map.keySet()) {
			String[] values = map.get(key);
			System.out.println(key+" "+Arrays.toString(values));
		}
		
		
		//2通过接口注入的方式获取request对象context对象
		request.setAttribute("requestName", "requestValue");
		request.getSession().setAttribute("sessionName", "sessionValue");
		context.setAttribute("applicationName", "applicationValue");
		
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
		
	}
}
