package action01;

import java.util.Map;

import org.apache.catalina.tribes.util.Arrays;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//一  完成解耦合的方式访问servletAPI  ==== ActionContext对象
public class RequestDemo1 extends ActionSupport {

	@Override
	public String execute() throws Exception {
		//使用struts2中的 
		//1接受参数
		ActionContext actionContext = ActionContext.getContext();
		
		Map<String, Object> map = actionContext.getParameters();//相当于request.getparemeterMap()
		
		for(String key:map.keySet()) {
			String[] values = (String[]) map.get(key);
			System.out.println(key + " " + Arrays.toString(values));
		}
		//2向域对象存入数据
		actionContext.put("requestName", "requestValue");  //相当于request.setAttribute()
		actionContext.getSession().put("sessionName", "sessionValue"); //相当于 request.getSession.setAttribute()
		actionContext.getApplication().put("applicationName", "applicationValue");  
		
		//只能操作域对象内的数据，无法使用api原有的方法,如获取ip地址，cookie等
		return SUCCESS;
	}
	
	
}
