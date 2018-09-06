package demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/***
 * 编写切面类
 * @author Administrator
 *
 */
public class MyAspectXML {

	/***
	 * 前置通知
	 * @param joinPoint
	 */
	public void checkPri(JoinPoint joinPoint) {
		System.out.println("=========权限校验=========="+joinPoint);
	}
	
	/***
	 * 后置通知，获取切入点执行返回值
	 */
	public void writeLog(Object result) {
		System.out.println("========日志记录=========="+result);
		
	}
	
	/***
	 * 环绕通知
	 * @throws Throwable 
	 */
	public Object arroud(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("======环绕前通知======");
		
		Object object = joinPoint.proceed();
		
		System.out.println("======环绕后通知======");
		
		return object;
	}
	
	/***
	 * 异常抛出通知
	 */
	public void erroThrow(Throwable ex) {
		System.out.println("======异常抛出通知======"+ex);
	}
	
	/***
	 * 最终通知 相当于finally代码块,无论有没有异常
	 */
	public void after() {
		System.out.println("======最终通知执行了=======");
	}
}
