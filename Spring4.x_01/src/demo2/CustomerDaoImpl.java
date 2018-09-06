package demo2;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save() {
		
		System.out.println("CustomerDaoImpl执行了。。。");
	}
	
	public void setup() {
		System.out.println("CustomerDaoImpl的setup方法执行了。。。");
		
	}
	
	public void destroy() {
		System.out.println("CustomerDaoImpl的destroy方法执行了。。。。。");
	}

}
