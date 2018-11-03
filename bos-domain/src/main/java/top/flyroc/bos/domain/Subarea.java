package top.flyroc.bos.domain;

/**
 * 分区
 */
@SuppressWarnings("all")
public class Subarea implements java.io.Serializable {

	private String id;
	private Decidedzone decidedzone;
	private Region region;
	private String addresskey;
	private String startnum;
	private String endnum;
	private String single;
	private String position;

	// 问题一：提交的表单中存在多个id参数	解决方案：将datagrid的filed由id改为subareaid
	// 问题二：提交的表单中subareaid参数的值为null
	// 此处为了解决decidedzone.jsp页面添加定区提交时表单项存在多个id参数的问题
	public String getSubareaid() {
		return id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Decidedzone getDecidedzone() {
		return this.decidedzone;
	}

	public void setDecidedzone(Decidedzone decidedzone) {
		this.decidedzone = decidedzone;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getAddresskey() {
		return this.addresskey;
	}

	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}

	public String getStartnum() {
		return this.startnum;
	}

	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}

	public String getEndnum() {
		return this.endnum;
	}

	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}

	public String getSingle() {
		return this.single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}