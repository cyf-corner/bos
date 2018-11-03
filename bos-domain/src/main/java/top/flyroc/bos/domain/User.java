package top.flyroc.bos.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
public class User implements java.io.Serializable {

	private String id;
	private String username;
	private String password;
	private Double salary;
	private Date birthday;
	private String gender;
	private String station;
	private String telephone;
	private String remark;
	private Set noticebills = new HashSet(0);
	private Set<Role> roles = new HashSet(0);

	public String getRoleNames() {
		StringBuilder sb = new StringBuilder("");
		for (Role role : roles) {
			String name = role.getName();
			sb.append(name + " ");
		}

		return sb.toString();
	}

	public String getBirthdayString() {
		if (birthday != null) {
			String format = new SimpleDateFormat("yyyy-MM-dd").format(birthday);

			return format;
		} else {

			return "暂无数据";
		}
	}

	public Set getNoticebills() {
		return noticebills;
	}

	public void setNoticebills(Set noticebills) {
		this.noticebills = noticebills;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}