package top.flyroc.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体
 */
@SuppressWarnings("all")
public class Role implements java.io.Serializable {

	private String id;
	private String name;
	private String code;
	private String description;

	private Set functions = new HashSet(0);// 无此地段，仅为表多对多关系 	当前角色====》多个权限
	private Set users = new HashSet(0);// 无此字段，仅为表达多对一关系		 	当前角色====》一个用户

	public Role() {
	}

	public Role(String id) {
		this.id = id;
	}

	public Role(String id, String name, String code, String description, Set functions, Set users) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.functions = functions;
		this.users = users;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getFunctions() {
		return this.functions;
	}

	public void setFunctions(Set functions) {
		this.functions = functions;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}