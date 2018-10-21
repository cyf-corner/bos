package top.flyroc.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import top.flyroc.domain.Customer;
import top.flyroc.domain.LinkMan;
import top.flyroc.service.ICustomerService;
import top.flyroc.service.ILinkManService;
import top.flyroc.vo.PageBean;

@SuppressWarnings("all")
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private ILinkManService linkmanService;
	private ICustomerService customerService;

	private Integer currentPage;// Action获取参数之----属性驱动
	private Integer pageSize;// Action获取参数之----属性驱动
	private LinkMan linkMan = new LinkMan();// Action获取参数之----模型驱动

	/*
	 * 联系人列表
	 */
	public String list() throws Exception {
		DetachedCriteria dcriteria = DetachedCriteria.forClass(LinkMan.class);
		if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
			dcriteria.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
		}
		if (linkMan.getCustomer() != null) {
			if (linkMan.getCustomer().getCust_id() != null) {
				dcriteria.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
			} else {
				if (StringUtils.isNotBlank(linkMan.getCustomer().getCust_name())) {
					// 根据cust_name去找到cust_id
					Customer c = customerService.getCustomerByName(linkMan.getCustomer().getCust_name());
					if (c != null && c.getCust_id() != null) {
						dcriteria.add(Restrictions.eq("customer.cust_id", c.getCust_id()));
					} else {
						dcriteria.add(Restrictions.eq("customer.cust_id", -1l));
					}
				}
			}
		}

		PageBean pageBean = linkmanService.getPageBean(dcriteria, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);

		return "list";
	}

	/*
	 * 添加联系人
	 */
	public String saveOrUpdate() throws Exception {
		linkmanService.saveOrUpdate(linkMan);

		return "toList";
	}

	/*
	 * 编辑联系人
	 */
	public String edit() throws Exception {
		LinkMan lmEdit = linkmanService.getLinkManById(linkMan.getLkm_id());
		ActionContext.getContext().put("lmEdit", lmEdit);// 放值到request域，并转发到编辑界面

		return "edit";
	}
	
	/*
	 * 删除客户
	 */
	public String delete() throws Exception {
		LinkMan lm = linkmanService.getLinkManById(linkMan.getLkm_id());
		linkmanService.delete(lm);

		return null;
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

	public void setLinkmanService(ILinkManService linkmanService) {
		this.linkmanService = linkmanService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public LinkMan getModel() {
		return linkMan;
	}

}
