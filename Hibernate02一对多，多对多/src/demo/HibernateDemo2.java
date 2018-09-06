package demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import domain.Role;
import domain.User;
import utils.HibernateUtils;

/*多对多的操作*/
/*多对多建立了双向关系的必须有一方放弃外键维护*/

public class HibernateDemo2 {
	
	/***
	 * 保存多个用户和角色
	 */
	@Test
	public void test1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx =  session.beginTransaction();
		
		User user1 = new User();
		user1.setUser_name("张三");
		User user2 = new User();
		user2.setUser_name("李四");
		
		Role role1 = new Role();
		role1.setRole_name("经理");	
		Role role2 = new Role();
		role2.setRole_name("员工");
		Role role3 = new Role();
		role3.setRole_name("销售");
		
		//设置双向关联关系
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		
		role1.getUsers().add(user1);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		role3.getUsers().add(user2);

		//保存操作：多对多建立了双向关系的必须有一方放弃外键维护
		//一般是被动方 放弃外键维护
		session.save(user1);
		session.save(user2);
		session.save(role1);
		session.save(role2);
		session.save(role3);

		tx.commit();
	}
	
	
	/***
	 * 多对多的级联保存和更新
	 * 保存用户级联保存角色
	 */
	@Test
	public void test2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx =  session.beginTransaction();
		
		User user1 = new User();
		user1.setUser_name("猪八戒");
		
		Role role1 = new Role();
		role1.setRole_name("CEO");	
		
		//设置双向关联关系
		user1.getRoles().add(role1);
		role1.getUsers().add(user1);
		
		//只保存用户
		session.save(user1);
		
		tx.commit();
	}
	
	
	/***
	 * 多对多的级联保存和更新
	 * 保存角色级联保存用户
	 */
	@Test
	public void test3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx =  session.beginTransaction();
		
		User user1 = new User();
		user1.setUser_name("猪八戒");
		
		Role role1 = new Role();
		role1.setRole_name("CEO");	
		
		//设置双向关联关系
		user1.getRoles().add(role1);
		role1.getUsers().add(user1);
		
		//只保存角色
		session.save(role1);
		
		tx.commit();
	}
	
	
	/***
	 * 多对多的级联删除（基本用不上）
	 * 删除用户级联删除角色 User.hbm.xml 设置cascade=delete
	 */
	@Test
	public void test4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx =  session.beginTransaction();
		
		//级联删除要先查询
		User user = session.get(User.class, 1l);
		session.delete(user);
		
		tx.commit();
	}

	
	
	/***
	 * 多对多的其他操作，给用户选择角色，
	 */
	@Test
	public void test5() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx =  session.beginTransaction();
		
		//给1号用户添加2号角色
		User user = session.get(User.class, 1l);
		//查询2号角色
		Role role = session.get(Role.class, 2l);
		user.getRoles().add(role);
		
		tx.commit();
	}

	/***
	 * 给用户删除改选角色
	 */
	@Test
	public void test6() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx =  session.beginTransaction();
		
		//给1号用户的2号角色删除添加为3号角色
		User user = session.get(User.class, 1l);
		//查询2，3号角色
		Role role2 = session.get(Role.class,2l);
		user.getRoles().add(role2);
		
		Role role3 = session.get(Role.class,3l);
		user.getRoles().add(role3);
		
		user.getRoles().remove(role2); //删除
		user.getRoles().add(role3); //添加
		
		tx.commit();
	}
	
	
	
}
