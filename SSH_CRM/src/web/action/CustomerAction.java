package web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Customer;
import domain.PageBean;
import domain.User;
import service.CustomerService;
import utils.UploadUtils;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>  {

	//模型驱动
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
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
	private Integer pageSize = 5;
	public void setPageSize(Integer pageSize) {
		if(pageSize == null) {
			pageSize = 5;
		}
		this.pageSize = pageSize;
	}

	//注入service
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	//Struts2的文件上传需要在Action中提供三个属性
	private String uploadFileName; //上传的文件名称
	private String uploadContentType; //上传的文件类型
	private File upload; //上传的文件
	
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	

	/***
	 * 列出所有客户
	 * @return "findAll"
	 */
	public String findAll() {
		//调用业务层查询
		//封装离线条件查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//设置查询条件 web层
		if(customer.getCust_name() != null) {
			//输入名称
			detachedCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		if(customer.getBaseDictSource() != null ) {
			if(customer.getBaseDictSource().getDict_id() != null && !"".equals(customer.getBaseDictSource().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id",customer.getBaseDictSource().getDict_id()));
			}
		}
	
		if(customer.getBaseDictLevel() != null ) {
			if(customer.getBaseDictLevel().getDict_id() != null && !"".equals(customer.getBaseDictLevel().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("baseDictLevel.dict_id",customer.getBaseDictLevel().getDict_id()));
			}
		}
		if(customer.getBaseDictIndustry() != null ) {
			if(customer.getBaseDictIndustry().getDict_id() != null && !"".equals(customer.getBaseDictIndustry().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("baseDictIndustry.dict_id",customer.getBaseDictIndustry().getDict_id()));
			}
		}
		
		
		System.out.println("currentPage:"+currentPage);
		System.out.println("pageSize:"+pageSize);
		PageBean <Customer>pageBean = customerService.findByPage(detachedCriteria, currentPage, pageSize);
		//保存到值栈
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(pageBean);
		//业务层方法
		return "findAll";
	}

	/***
	 * 进入保存客户
	 * @return "enterAdd"
	 */
	public String enterAdd() {
		
		return "enterAdd";
	}
	
	/***
	 * 保存客户
	 * @return "saveSuccess"
	 * @throws IOException 
	 */
	public String save() throws IOException {
		if(upload != null) {
			String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
			//根路径
			String path1 = "I:\\upload\\";
			//相对路径
			String path2 = UploadUtils.getPath(uuidFileName);
			
			String realPath = path1+path2;
			//创建目录
			File f = new File(realPath);
			if(!f.exists()) {
				f.mkdirs();
			}
			//文件上传
			File destFile = new File(realPath+"\\"+uuidFileName);
			FileUtils.copyFile(upload, destFile);
			//将文件路径加入用户数据库
			customer.setCust_image(realPath+"\\"+uuidFileName);
		}
		customerService.save(customer);
		return "saveSuccess";
	}
	
	/***
	 * 删除客户
	 */
	public String delete() {
		//先查询再删除，方便级联删除
		customer = customerService.findById(customer.getCust_id());
		//删除图片
		if(customer.getCust_image() != null) {
			File f = new File(customer.getCust_image());
			if(f.exists()) {
				f.delete();
			}
		}
		//删除客户
		customerService.delete(customer);
		return "deleteSuccess";
	}

	
	/***
	 * 进入修改客户
	 */
	public String edit() {
		//获取修改的客户
		customer = customerService.findById(customer.getCust_id());
		//将customer传递到页面
		//方法一，手动压栈<s:property value="cust_name"/>
		//ActionContext.getContext().getValueStack().push(customer);
		//方法二，模型驱动对象默认在栈顶<s:property value="model.cust_name"/>
		
		return "enterEdit";
	}
	
	
	/***
	 * 提交修改客户
	 * @throws IOException 
	 */
	public String updateCustomer() throws IOException {
		//文件项是否已经选择，如果选择了，就删除原有文件，上传新文件。如果没有选，使用原有即可
		if(upload != null) {
			//已经选择了
			//删除原有文件
			String cust_image = customer.getCust_image();
			if (cust_image != null || "".equals(cust_image)) {
				File file = new File(cust_image);
				file.delete();
			}
			//文件上传
			String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
			//根路径
			String path1 = "I:\\upload\\";
			//相对路径
			String path2 = UploadUtils.getPath(uuidFileName);
			
			String realPath = path1+path2;
			//创建目录
			File f = new File(realPath);
			if(!f.exists()) {
				f.mkdirs();
			}
			//文件上传
			File destFile = new File(realPath+"\\"+uuidFileName);
			FileUtils.copyFile(upload, destFile);
			//将文件路径加入用户数据库
			customer.setCust_image(realPath+"\\"+uuidFileName);
		}
		customerService.update(customer);
		return "updateSuccess";
	}
	
	
	
	
	
	
	
}
