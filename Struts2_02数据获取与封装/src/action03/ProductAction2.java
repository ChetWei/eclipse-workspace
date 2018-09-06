package action03;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
//Struts的复杂数据类型封装  -- 封装到Map中

import domain.Product;

public class ProductAction2 extends ActionSupport {

	private Map<String,Product> product_map;

	public Map<String, Product> getProduct_map() {
		return product_map;
	}

	public void setProduct_map(Map<String, Product> product_map) {
		this.product_map = product_map;
	}
	
	@Override
	public String execute() throws Exception {
		for(String key : product_map.keySet()) {
			Product product = product_map.get(key);
			System.out.println(product);
			
		}
		return NONE;
	}
	
}
