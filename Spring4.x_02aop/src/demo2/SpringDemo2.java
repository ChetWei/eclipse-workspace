package demo2;

import java.lang.reflect.Proxy;

public class SpringDemo2 {

	CustomerDao customerDao = new CustomerDao();
	CustomerDao proxy = new CglibProxy(customerDao).createProxy();

}
