package demo4;

import demo3.Phone;

/**
 * SpEL表达式属性注入
 */
public class Book {
	private String name;
	private Double price;
	
	private Phone phone;
	private Double NUM = new Double(999999999);
	
	public Double caculatePrice() {   //新增加的方法，通过SpEL表达式在xml中使用
		return NUM*3;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + ", phone=" + phone + "]";
	}




	
	
	
}
