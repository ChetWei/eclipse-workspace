package demo3;

public class Employee {

	private String name;
	private Phone phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", phone=" + phone + "]";
	}
	
	
}
