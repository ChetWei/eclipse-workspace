package daoImpl;

import dao.BaseDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends  HibernateDaoSupport implements BaseDao<T> {
	
	private Class clazz ;
	
	public BaseDaoImpl() {
		//反射，第一步获得Class
		Class clazz = this.getClass(); //正在被调用的类的Class,本身或子类
		//查看JDK api
		Type type = clazz.getGenericSuperclass(); //参数化类型 BaseDaoImpl<Customer>  BaseDaoImpl<LinkMan>...
		//将type强转为参数化类型
		ParameterizedType pType = (ParameterizedType) type ;
		//通过参数化类型，获得实际类型参数的数组
		Type[] types = pType.getActualTypeArguments();
		//只获得第一个实际类型参数即可
		this.clazz = (Class) types[0]; //Customer,LinkMan ...
		
		
	}
	
	//保存
	@Override
	public void save(T t) {
		Serializable save = this.getHibernateTemplate().save(t);
	}
	
	//删除
	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	//更新
	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}
	
	//查询单个
	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	
	//查询所有方法
	@Override
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}
	
	//统计个数方法

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		//设置统计个数条件
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size() > 0 ) {
			return list.get(0).intValue();
		}
		return null;
	}
	
	// 分页查询

	@Override
	public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null); //清空条件
		
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
	}

}
