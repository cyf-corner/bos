package top.flyroc.bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import top.flyroc.bos.utils.PageBean;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	protected T model;// protected修饰符，子类可以访问

	// 属性驱动，接收页面提交的分页参数？？？为什么这里可以删除掉属性驱动的声明？？？
	// protected int page;// 当前页码
	// protected int rows;// 每页显示条数
	protected PageBean pageBean = new PageBean();

	// 创建离线查询对象
	protected DetachedCriteria dc = null;

	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}

	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}

	public void java2Json(Object o, String[] excludes) {
		// 使用json-lib将PageBean对象转为json，通过输出流写到页面
		// JSONObject---->将单一对象转为json
		// JSONArray ---->将数组或者集合对象转为json
		JsonConfig jsonConfig = new JsonConfig();
		// 指定那些属性不需要转为json
		jsonConfig.setExcludes(excludes);// 前端需要ajax{"total":xxx,"rows":[{"id":"001"},{"name":"cyf"}]}
		String json = JSONObject.fromObject(o, jsonConfig).toString();

		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void java2Json(List o, String[] exclueds) {
		JsonConfig jsonConfig = new JsonConfig();
		// 指定哪些属性不需要转json
		jsonConfig.setExcludes(exclueds);
		String json = JSONArray.fromObject(o, jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public T getModel() {

		return model;
	}

	// 在构造方法中动态获取实体类型，通过反射创建model对象
	public BaseAction() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];

		dc = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(dc);

		// 通过反射创建对象
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
