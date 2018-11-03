package top.flyroc.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.flyroc.bos.domain.Noticebill;
import top.flyroc.bos.service.INoticebillService;
import top.flyroc.bos.web.action.base.BaseAction;
import top.flyroc.crm.Customer;
import top.flyroc.crm.ICustomerService;

@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill> {

	@Autowired
	private INoticebillService noticebillService;

	/*
	 * 保存一个业务通知单，并尝试自动分单
	 */
	public String add() {
		noticebillService.save(model);

		return "noticebill_add";
	}

	/*
	 * 远程调用crm服务，根据手机号查询客户信息
	 */
	@Autowired
	private ICustomerService customerService;

	public String findCustomerByTelephone() {
		String telephone = model.getTelephone();
		Customer customer = customerService.findCustomerByTelephone(telephone);
		this.java2Json(customer, new String[] {});

		return NONE;
	}
}
