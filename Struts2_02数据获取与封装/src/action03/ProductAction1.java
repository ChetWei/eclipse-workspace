package action03;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.Product;
//Struts的复杂数据类型封装  -- 封装到List集合
public class ProductAction1 extends ActionSupport {

	private List<Product> product_list;

	public List<Product> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}
	
	@Override
	public String execute() throws Exception {
		for(Product product:product_list) {
			System.out.println(product);
		}
		return NONE;
	}
}
