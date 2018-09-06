package demo3;

/***
 * 构造方法的属性注入
 */
public class Car {
	private String name;
	private Double price;
	
	public Car(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}
