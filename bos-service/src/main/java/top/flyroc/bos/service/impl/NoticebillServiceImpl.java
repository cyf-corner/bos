package top.flyroc.bos.service.impl;

import java.sql.Timestamp;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flyroc.bos.dao.IDecidedzoneDao;
import top.flyroc.bos.dao.INoticebillDao;
import top.flyroc.bos.dao.IWorkbillDao;
import top.flyroc.bos.domain.Decidedzone;
import top.flyroc.bos.domain.Noticebill;
import top.flyroc.bos.domain.Staff;
import top.flyroc.bos.domain.User;
import top.flyroc.bos.domain.Workbill;
import top.flyroc.bos.service.INoticebillService;
import top.flyroc.crm.ICustomerService;

@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private INoticebillDao noticebillDao;
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private IWorkbillDao workbillDao;

	/*
	 * 保存业务通知单并完成分单操作
	 */
	public void save(Noticebill model) {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		model.setUser(user);// 设置当前登录用户
//		noticebillDao.save(model);

		// 远程调用crm服务，根据取件地址查询该客户所属的定区id
		String decidedzoneId = customerService.findDecidedzoneIdByAddress(model.getPickaddress());
		if (decidedzoneId != null) {
			// 查询到了定区id---->自动分单
			Decidedzone decidedzone = decidedzoneDao.findById(decidedzoneId);
			Staff staff = decidedzone.getStaff();
			model.setStaff(staff);// 业务通知单关联取派员对象
			// 设置分单类型为：自动分单
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			// 为该取派员产生一个工单
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);// 追单次数
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));// 创建时间，当前系统时间
			workbill.setNoticebill(model);// 工单关联页面通知单
			workbill.setPickstate(Workbill.PICKSTATE_NO);// 取件状态
			workbill.setRemark(model.getRemark());// 备注信息
			workbill.setStaff(staff);// 工单关联取派员
			workbill.setType(Workbill.TYPE_1);// 工单类型
			workbillDao.save(workbill);
			// 调用短信平台，发送短信
		} else {
			// 没有查询到定区id，不能完成自动分单
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);// 设置分单类型为：手动分单
		}
noticebillDao.save(model);
	}
}
