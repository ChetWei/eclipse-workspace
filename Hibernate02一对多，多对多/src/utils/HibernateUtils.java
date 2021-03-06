package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	public static final Configuration cfg;
	public static final SessionFactory sf;
	
	static {
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	
	//直接获取一个新的session
	public static Session openSession() {
		return sf.openSession();
	}
	
	//获取线程绑定session
	public static Session getCurrentSession() {
		return sf.getCurrentSession();
	}
}
