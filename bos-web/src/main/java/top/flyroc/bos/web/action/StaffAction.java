package top.flyroc.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.flyroc.bos.domain.Staff;
import top.flyroc.bos.service.IStaffService;
import top.flyroc.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Autowired
	private IStaffService staffService;

	/*
	 * 添加取派员
	 */
	public String add() {
		staffService.save(model);

		return "list";
	}

	/*
	 * 分页查询
	 */
	public String pageQuery() throws IOException {
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		dc.add(Restrictions.eq("deltag", "0"));
		staffService.pageQuery(pageBean);
		java2Json(pageBean, new String[] { "currentPage", "detachedCriteria", "pageSize", "decidedzones" });

		return NONE;
	}

	private String ids;// 属性驱动，接收页面提交的ids参数

	/*
	 * 取派员批量删除
	 */
	// Shiro框架提供的权限控制方式二(基于代理技术实现)：方法注解控制权限
	@RequiresPermissions("staff.delete")// 执行这个方法需要当前用户具有staff-delete这个权限，若没有此权限会抛出UnauthorizedException异常
	public String deleteBatch() {
		staffService.deleteBatch(ids);

		return "list";
	}

	/*
	 * 修改取派员信息
	 */
	public String edit() {
		// Shiro框架提供的权限控制方式四(基于代理技术实现)：代码级别权限控制
//		Subject subject = SecurityUtils.getSubject();
//		subject.checkPermission("staff.edit");
		
		Staff staff = staffService.findById(model.getId());
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);

		return "list";
	}

	/*
	 * 查询所有未删除的取派员，返回json
	 */
	public String listajax() {
		List<Staff> list = staffService.findListNotDelete();
		this.java2Json(list, new String[] { "decidedzones" });

		return NONE;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
	 * ====================分页查询=========================== public String pageQuery()
	 * throws IOException { PageBean pageBean = new PageBean();
	 * pageBean.setCurrentPage(page); pageBean.setPageSize(rows);
	 * 
	 * // 创建离线查询对象 DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
	 * dc.add(Restrictions.eq("deltag", "0")); pageBean.setDetachedCriteria(dc);
	 * staffService.pageQuery(pageBean);
	 * 
	 * // 使用json-lib将PageBean对象转为json，通过输出流写到页面 // JSONObject---->将单一对象转为json //
	 * JSONArray ---->将数组或者集合对象转为json JsonConfig jsonConfig = new JsonConfig(); //
	 * 指定那些属性不需要转为json jsonConfig.setExcludes(new String[] { "currentPage",
	 * "detachedCriteria", "pageSize" });//
	 * 前端需要ajax{"total":xxx,"rows":[{"id":"001"},{"name":"cyf"}]} String json =
	 * JSONObject.fromObject(pageBean, jsonConfig).toString();
	 * 
	 * ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
	 * ServletActionContext.getResponse().getWriter().print(json);
	 * 
	 * return NONE; }
	 */
}
