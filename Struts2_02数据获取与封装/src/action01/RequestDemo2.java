package action01;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class RequestDemo2 extends ActionSupport {
//二 使用servlet API的原生方式     ServletActionContext
	//这种方式可以操作域对象的数据，同时也可以获得对象的方法
	@Override
	public String execute() throws Exception {
		//1接收数据
		System.out.println("action2");
		HttpServletRequest request =ServletActionContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		for(String key: map.keySet()) {
			String[] values = map.get(key);
			System.out.println(key+" "+Arrays.toString(values));
		}
		
		//2向域对象存入数据
		request.setAttribute("requestName", "reqeustValue");
		request.getSession().setAttribute("sessionName", "sessionValue");
		ServletActionContext.getServletContext().setAttribute("applicationName","applicationValue" );
		
		return SUCCESS;
	}
}
