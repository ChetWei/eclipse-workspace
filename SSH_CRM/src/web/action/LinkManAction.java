package web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Customer;
import domain.LinkMan;
import domain.PageBean;
import service.CustomerService;
import service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	//模型驱动使用对象
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	//注入service
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	//使用set方法接受当前页
	private Integer currentPage = 1;
	public void setCurrentPage(Integer currentPage) {
		if(currentPage == null) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}
	//使用set方法接受每页的页数
	private Integer pageSize = 3;
	public void setPageSize(Integer pageSize) {
		if(pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	
	/***
	 * 查询所有，分页查询
	 * @return
	 */
	public String findAll() {
		//离线条件查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		//设置条件
		if(linkMan.getLkm_name() != null) {
			//名称查询
			detachedCriteria.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		
		if(linkMan.getLkm_gender() !=null && !"".equals(linkMan.getLkm_gender())){
			//性别查询
			detachedCriteria.add(Restrictions.eq("lkm_gender", linkMan.getLkm_gender()));
		}
		
		PageBean<LinkMan> pageBean = linkManService.finAll(detachedCriteria,currentPage,pageSize);
		//保存到值栈
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(pageBean);
		
		return "findAll";
	}
	
	/***
	 * 进入编辑
	 */
	public String enterEdit() {
		List<Customer> list = customerService.findAll();
		//将 customer list保存到值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		linkMan = linkManService.findById(linkMan.getLkm_id());
		//将对象的值放入值栈
		ActionContext.getContext().getValueStack().push(linkMan);
		return "enterEdit";
	}
	
	/***
	 * 提交编辑联系人
	 */
	public String update() {
		linkManService.update(linkMan);
		return "updateSuccess";
	}
	
	
	/***
	 * 删除联系人
	 */
	public String delete() {
		//根据id查询到联系人
		linkMan = linkManService.findById(linkMan.getLkm_id());
		linkManService.delete(linkMan);
		return "deleteSuccess";
	}
	
	/***
	 * 进入添加联系人
	 * @return
	 */
	public String enterAdd() {
		List<Customer> list = customerService.findAll();
		//将 customer list保存到值栈中
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "enterAdd";
	}
	
	public String save() {
		
		linkManService.save(linkMan);
		return "addSuccess";
	}

	
	
}
