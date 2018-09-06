package demo3;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void save() {
		System.out.println("save....");

	}

	@Override
	public String find() {
		System.out.println("find....");
		return "find方法执行了";

	}

	@Override
	public void add() {
		System.out.println("add....");
		int i = 1/0;
	}

}
