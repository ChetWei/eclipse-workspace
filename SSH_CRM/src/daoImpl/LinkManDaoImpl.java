package daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.LinkManDao;
import domain.Customer;
import domain.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	@Override
	//总记录数
	public Long findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount()); //设置条件count(*)
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0) {
			return list.get(0).longValue();
		}
		return null;
	}

	@Override
	//分页查询联系人对象集合
	public List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null); //清除已经设置的条件
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
		return list;
	}

	//保存单个联系人
	@Override
	public void save(LinkMan linkman) {
		Serializable save = this.getHibernateTemplate().save(linkman);
		
	}

	//删除单个联系人
	@Override
	public void delete(LinkMan linkman) {
		this.getHibernateTemplate().delete(linkman);
		
	}

	//更新单个联系人
	@Override
	public void update(LinkMan linkman) {
		this.getHibernateTemplate().update(linkman);
		
	}

	//根据id查找联系人
	@Override
	public LinkMan findById(Long id) {
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().find("from domain.LinkMan l where l.lkm_id = ?0", id);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
