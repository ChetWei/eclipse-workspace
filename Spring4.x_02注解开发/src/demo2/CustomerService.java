package demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//注解开发  》》》 bean的生命周期//<bean id="" class="" init-method="" destroy-method="" />，作用范围单例多例
@Service("customerService")
@Scope("prototype") //设置作用范围为多例（默认单例singleton）
public class CustomerService {
	
	@PostConstruct //相当于init-method=""
	public void init() {
		System.out.println("init.....");
	}
	
	public void save() {
		System.out.println("save....");
	}
	
	@PreDestroy //相当于destroy-method=""
	public void destroy() {
		System.out.println("destroy.....");
	}
}
