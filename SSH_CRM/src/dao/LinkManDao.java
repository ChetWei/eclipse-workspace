package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.LinkMan;

public interface LinkManDao  {

	Long findCount(DetachedCriteria detachedCriteria);

	List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

	LinkMan findById(Long id);
	void save(LinkMan linkman);
	void delete(LinkMan linkman);
	void update(LinkMan linkman);
}
