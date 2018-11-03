package top.flyroc.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 定区
 */
@SuppressWarnings("all")
public class Decidedzone implements java.io.Serializable {

	private String id;
	private Staff staff;
	private String name;
	
	// 无此字段，表达一对多关系
	private Set subareas = new HashSet(0);

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getSubareas() {
		return this.subareas;
	}

	public void setSubareas(Set subareas) {
		this.subareas = subareas;
	}

}