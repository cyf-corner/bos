package top.flyroc.web.action;

import java.io.File;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import top.flyroc.domain.Customer;
import top.flyroc.service.ICustomerService;
import top.flyroc.vo.PageBean;

@SuppressWarnings("all")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private ICustomerService customerService;

	private Integer currentPage;// Action获取参数之----属性驱动
	private Integer pageSize;// Action获取参数之----属性驱动
	private Customer customer = new Customer();// Action获取参数之----模型驱动

	private File file;// struts2提供的文件上传功能示例
	private String fileFileName;
	private String fileContentType;

	/*
	 * 客户列表
	 */
	public String list() throws Exception {
		DetachedCriteria dcriteria = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dcriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}

		PageBean pageBean = customerService.getPageBean(dcriteria, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);

		return "list";
	}

	/*
	 * 添加客户
	 */
	public String add() throws Exception {
		if (file != null) {
			file.renameTo(new File("E:\\eclipse\\ssh-workspace\\ssh_crm\\src\\main\\webapp\\upload\\" + fileFileName));
		}

		if (customer.getCust_id() != null) {// 如果此次是修改操作
			customerService.update(customer);
		} else { // 如果此次是新增操作
			customerService.save(customer);
		}

		return "toList";
	}

	/*
	 * 编辑客户
	 */
	public String edit() throws Exception {
		Customer c = customerService.getCustomerById(customer.getCust_id());
		ActionContext.getContext().put("customer", c);// 放值到request域，并转发到编辑界面

		return "edit";
	}

	/*
	 * 删除客户
	 */
	public String delete() throws Exception {
		Customer c = customerService.getCustomerById(customer.getCust_id());
		customerService.delete(c);

		return null;
	}

	/*
	 * 客户行业统计(多表查询经典案例)
	 */
	public String industryCount() throws Exception {
		List<Object[]> list = customerService.getIndustryCount();
		ActionContext.getContext().put("list", list);

		return "industryCount";
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

}
