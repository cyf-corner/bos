package top.flyroc.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.flyroc.bos.domain.Decidedzone;
import top.flyroc.bos.domain.Subarea;
import top.flyroc.bos.service.IDecidedzoneService;
import top.flyroc.bos.web.action.base.BaseAction;
import top.flyroc.crm.Customer;
import top.flyroc.crm.ICustomerService;

@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {

	// 属性驱动，接收多个分区id
	private String[] subareaid;// subareaid: bj001 subareaid: hb001

	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}

	@Autowired
	private IDecidedzoneService decidedzoneService;

	/*
	 * 添加定区
	 */
	public String add() {
		decidedzoneService.save(model, subareaid);

		return "list";
	}

	/*
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException {
		decidedzoneService.pageQuery(pageBean);
		this.java2Json(pageBean,
				new String[] { "currentPage", "detachedCriteria", "pageSize", "subareas", "decidedzones" });
		// 分页查询死循环情况一：页面不需要关联数据时 ---->此例subareas既为不需要关联数据，因此直接排除此属性
		// 解决办法====》将关联对象属性排除掉
		// 分页查询死循环情况二：页面需要关联数据时
		// ---->此例staff既为需要关联数据，因此需要将Decidedzone.hbm.xml文件中staff加载策略设置为立即加载，并且，staff本身有decidezones的属性，因此需要将其排除
		// 解决办法====》将关联对象改为立即加载，并且将关联对象中的属性排除

		return NONE;
	}

	public String findHasAssociationSubarea() {
		List<Subarea> list = decidedzoneService.findHasAssociationSubarea(model.getId());
		this.java2Json(list, new String[] { "decidedzone", "subareas" });

		return NONE;
	}

	/*
	 * ============================================================CFX============================================================
	 */
	@Autowired
	private ICustomerService proxy;// 属性驱动

	/*
	 * 通过CXF查询未关联定区的客户
	 */
	public String findListNotAssociation() {
		List<Customer> list = proxy.findListNotAssociation();
		this.java2Json(list, new String[] {});

		return NONE;
	}

	/*
	 * 通过CXF查询已关联定区的客户
	 */
	public String findListHasAssociation() {
		List<Customer> list = proxy.findListHasAssociation(model.getId());
		this.java2Json(list, new String[] {});

		return NONE;
	}

	/*
	 * 通过CXF对Customer进行定区关联操作
	 */
	private List<Integer> customerIds;// 属性驱动，接收页面提交的多个客户id

	public String assigncustomerstodecidedzone() {
		proxy.assigncustomerstodecidedzone(model.getId(), customerIds);

		return "list";
	}

	public List<Integer> getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}

}
