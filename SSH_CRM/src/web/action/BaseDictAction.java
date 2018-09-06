package web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.BaseDict;
import domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import service.BaseDictService;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict>{

	//对象模型驱动获得数据
	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}

	//注入service
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
	
	public String findByTypeCode() throws IOException {
		
		List <BaseDict>list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
		
		//将list转为JSON ---jsonlib  fastjson
		/***
		 * JSONConfig 转JSON的配置对象
		 * JSONArray 将数组和list集合转为JSON
		 * JSONObject 将对象和Map集合转JSON
		 */
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"dict_enable","dict_memo","dict_sort"}); //去除内容
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		System.out.println(jsonArray.toString());
		//将JSON输出到页面
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
	
}
