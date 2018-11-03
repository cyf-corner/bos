package top.flyroc.bos.web.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.flyroc.bos.domain.Function;
import top.flyroc.bos.service.IFunctionService;
import top.flyroc.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function> {

	@Autowired
	private IFunctionService functionService;

	/*
	 * 查询所有权限，返回json数据给下拉列表
	 */
	public String listAjax() {
		List<Function> list = functionService.findAll();
		// 这里转ajax记得不要排除children属性
		this.java2Json(list, new String[] { "parentFunction", "roles" });

		return NONE;
	}

	/*
	 * 添加权限
	 */
	public String add() {
		functionService.save(model);

		return "list";
	}

	/*
	 * 分页查询
	 */
	public String pageQuery() {
		// 此处由于页面表单page字段和Function类page属性名重复，因此page的值会通过setter方法给到Function类的page属性
		// 为了处理该错误的方式简化，因此在此将page的值手动赋值给pageBean对象的page属性
		pageBean.setCurrentPage(Integer.parseInt(model.getPage()));
		functionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[] { "currentPage", "detachedCriteria", "pageSize", "parentFunction", "roles", "children" });

		return NONE;
	}

	/*
	 * 根据当前登陆用户显示对应权限的菜单数据
	 */
	public String findMenu() {
		List<Function> list = functionService.findMenu();
		this.java2Json(list, new String[] { "parentFunction", "children", "roles" });// 这里选择把children排除，因此需要特殊处理

		return NONE;
	}
}
