package service;

import org.hibernate.criterion.DetachedCriteria;

import domain.LinkMan;
import domain.PageBean;

public interface LinkManService {

	PageBean<LinkMan> finAll(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	void delete(LinkMan linkman);
	
	void update(LinkMan linkman);
	
	void save(LinkMan linkman);
	
	LinkMan findById(Long id);
}
