package demo3;

/***
 * bean 的属性注入，setter getter 方式
 */
public class Phone {

	private String name;
	private Double size;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Phone [name=" + name + ", size=" + size + "]";
	}
	
	
}
