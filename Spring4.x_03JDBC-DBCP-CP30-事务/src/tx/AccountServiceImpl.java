package tx;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)//第三种注解方式
public class AccountServiceImpl implements AccountService {

	//注入Dao
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
/*	//第一种注入事务的管理模板类  transactionTemplate
	private TransactionTemplate transactionTemplate;
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}*/


	/***
	 * from 转出账号
	 * to 转入账号
	 * money 金额
	 */
	@Override
	public void transfer(String from, String to, Double money) {
	
	/*	//第一种使用事务处理模块,编程式事务管理需要手动编写代码
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				accountDao.outMoney(from, money);
				int i = 1/0;
				accountDao.inMoney(to, money);			
			}
		});*/
		
		
		//第二种 通过配置文件实现（AOP）、第三种
		accountDao.outMoney(from, money);
		int i =1/0; //添加异常
		accountDao.inMoney(to, money);
	
		
		
	}



}
