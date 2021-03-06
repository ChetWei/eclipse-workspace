package serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.LinkManDao;
import domain.LinkMan;
import domain.PageBean;
import service.LinkManService;

@Transactional
public class LinkManServiceImpl implements LinkManService {

	//注入对象
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	
	
	//分页查询联系人
	@Override
	public PageBean<LinkMan> finAll(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		PageBean<LinkMan> pageBean = new PageBean();
		//封装页数
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		//总记录数
		Integer totalCount = linkManDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//总页数
		Double num = Math.ceil(totalCount.doubleValue()/pageSize);
		pageBean.setTotalPage(num.longValue());
		//每页显示数据的集合
		Integer begin = (currentPage -1) * pageSize ;
		//分页查询联系人对象集合
		List list = linkManDao.findByPage(detachedCriteria,begin,pageSize);
		
		pageBean.setList(list);
		
		return pageBean;
	}
	
	//删除联系人
	@Override
	public void delete(LinkMan linkman) {
		linkManDao.delete(linkman);
		
	}
	
	//更新联系人
	@Override
	public void update(LinkMan linkman) {
		linkManDao.update(linkman);	
	}
	
	//保存联系人
	@Override
	public void save(LinkMan linkman) {
		linkManDao.save(linkman);
		
	}
	
	
	//根据id查询联系人
	@Override
	public LinkMan findById(Long id) {
		return linkManDao.findById(id);
	}
	
}
