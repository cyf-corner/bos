package top.flyroc.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.flyroc.bos.domain.Role;
import top.flyroc.bos.service.IRoleService;
import top.flyroc.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	@Autowired
	private IRoleService roleService;

	private String functionIds;// 属性驱动

	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}

	/*
	 * 添加角色
	 */
	public String add() {
		roleService.save(model, functionIds);

		return "list";
	}

	/*
	 * 分页
	 */
	public String pageQuery() {
		roleService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] { "functions", "users" });

		return NONE;
	}

	/*
	 * 添加用户下拉框，所有角色查询
	 */
	public String listAjax() {
		List<Role> list = roleService.findAll();
		this.java2Json(list, new String[] { "functions", "users" });

		return NONE;
	}

	/*
	 * 修改
	 */
	public String edit() {
		// TODO 待开发

		return "list";
	}

}
