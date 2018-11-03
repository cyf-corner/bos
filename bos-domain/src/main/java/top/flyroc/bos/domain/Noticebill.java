package top.flyroc.bos.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 业务通知单
 */
@SuppressWarnings("all")
public class Noticebill implements java.io.Serializable {

	private String id;// 业务单主键
	private User user; // 受理人----------------------外键---->User
	private Staff staff; // 取派员----------------------外键---->Staff
	private String customerId; // 客户编号====》逻辑外键
	private String customerName; // 客户姓名
	private String delegater; // 联系人
	private String telephone; // 电话
	private String pickaddress; // 取件地址
	private String arrivecity; // 到达城市
	private String product; // 产品
	private Date pickdate; // 预约取件时间
	private Integer num; // 件数
	private Double weight; // 重量
	private String volume; // 体积
	private String remark; // 备注
	private String ordertype;// 分单类型：自动分单、人工分单

	// 无此字段，为表一对多关系
	private Set workbills = new HashSet(0);

	public static final String ORDERTYPE_AUTO = "自动分单";
	public static final String ORDERTYPE_MAN = "人工分单";

	public Noticebill() {
	}

	public Noticebill(String id) {
		this.id = id;
	}

	public Noticebill(String id, User user, Staff staff, String customerId, String customerName, String delegater,
			String telephone, String pickaddress, String arrivecity, String product, Date pickdate, Integer num,
			Double weight, String volume, String remark, String ordertype, Set workbills) {
		this.id = id;
		this.user = user;
		this.staff = staff;
		this.customerId = customerId;
		this.customerName = customerName;
		this.delegater = delegater;
		this.telephone = telephone;
		this.pickaddress = pickaddress;
		this.arrivecity = arrivecity;
		this.product = product;
		this.pickdate = pickdate;
		this.num = num;
		this.weight = weight;
		this.volume = volume;
		this.remark = remark;
		this.ordertype = ordertype;
		this.workbills = workbills;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDelegater() {
		return this.delegater;
	}

	public void setDelegater(String delegater) {
		this.delegater = delegater;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPickaddress() {
		return this.pickaddress;
	}

	public void setPickaddress(String pickaddress) {
		this.pickaddress = pickaddress;
	}

	public String getArrivecity() {
		return this.arrivecity;
	}

	public void setArrivecity(String arrivecity) {
		this.arrivecity = arrivecity;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getPickdate() {
		return this.pickdate;
	}

	public void setPickdate(Date pickdate) {
		this.pickdate = pickdate;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Set getWorkbills() {
		return this.workbills;
	}

	public void setWorkbills(Set workbills) {
		this.workbills = workbills;
	}

}