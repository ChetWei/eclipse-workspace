package demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/***
 * Spring AOP的注解开发 注解的切面类
 * @author Administrator
 *
 */
@Aspect
public class MyAspectAnno {

	//前置通知
	/*@Before(value="execution(* demo1.OrderDao.add(..))")  */
	@Before(value="MyAspectAnno.pointcut1()")  //使用切入点配置
	public void before() {
		System.out.println("====前置增强====");
	}
	
	//后置通知
	/*@AfterReturning(value="execution(* demo1.OrderDao.save(..))",returning="result")*/
	@AfterReturning(value="MyAspectAnno.pointcut3()",returning="result") //使用切入点配置
	public void afterReturning(Object result) {
		System.out.println("====后置通知===="+result);
	}
	
	//环绕通知
	/*@Around(value="execution(* demo1.OrderDao.delete(..))")*/
	public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("====环绕前通知====");
		Object obj = joinPoint.proceed();
		System.out.println("====环绕后通知====");
		return obj;
	}
	//异常抛出通知
	/*@AfterThrowing(value="execution(* demo1.OrderDao.delete(..))",throwing="e")*/
	public void afterThrowing(Throwable e) {
		System.out.println("====异常抛出通知===="+e.getMessage());
		
	}
	
	//最终通知
	/*@After(value="execution(* demo1.OrderDao.add(..))")*/
	public void after() {
		System.out.println("====最终通知====");
	}
	
	//Spring AOP切入点的配置
	@Pointcut(value="execution(* demo1.OrderDao.delete(..))")
	private void pointcut1() {}
	
	@Pointcut(value="execution(* demo1.OrderDao.add(..))")
	private void pointcut2() {}
	
	@Pointcut(value="execution(* demo1.OrderDao.save(..))")
	private void pointcut3() {}
	
}
