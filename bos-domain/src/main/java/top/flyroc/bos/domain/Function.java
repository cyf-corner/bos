package top.flyroc.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 权限实体
 */
@SuppressWarnings("all")
public class Function implements java.io.Serializable {

	private String id;
	private Function parentFunction;// 当前权限的上级权限
	private String name;
	private String code;
	private String description;
	private String page;
	private String generatemenu;// 是否生成菜单，1：是 0：否
	private Integer zindex;
	private Set children = new HashSet(0);// 当前权限的下级权限

	private Set roles = new HashSet(0);// 无此地段，仅为表多对多关系 当前权限====》多个角色

	// 由于index.jsp中ztree树加载需要pId属性，因此这里提供getpId方法
	public String getpId() {
		if (parentFunction == null) {
			return "0";
		}
		return parentFunction.getId();
	}

	public Function() {
		super();
	}

	public Function(String id) {
		super();
		this.id = id;
	}

	public Function(String id, Function parentFunction, String name, String code, String description, String page,
			String generatemenu, Integer zindex, Set children, Set roles) {
		super();
		this.id = id;
		this.parentFunction = parentFunction;
		this.name = name;
		this.code = code;
		this.description = description;
		this.page = page;
		this.generatemenu = generatemenu;
		this.zindex = zindex;
		this.children = children;
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Function getParentFunction() {
		return parentFunction;
	}

	public void setParentFunction(Function parentFunction) {
		this.parentFunction = parentFunction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getGeneratemenu() {
		return generatemenu;
	}

	public void setGeneratemenu(String generatemenu) {
		this.generatemenu = generatemenu;
	}

	public Integer getZindex() {
		return zindex;
	}

	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}

	public Set getRoles() {
		return roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}
}