package top.flyroc.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 区域
 */
@SuppressWarnings("all")
public class Region implements java.io.Serializable {

	private String id;
	private String province;
	private String city;
	private String district;
	private String postcode;
	private String shortcode;
	private String citycode;
	
	// 无此字段，为表达一对多的关系
	private Set subareas = new HashSet(0);

	public Region() {
		super();
	}

	public Region(String id, String province, String city, String district, String postcode, String shortcode,
			String citycode, Set subareas) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
		this.district = district;
		this.postcode = postcode;
		this.shortcode = shortcode;
		this.citycode = citycode;
		this.subareas = subareas;
	}

	/*
	 * 此处为了subarea.jsp页面下拉列表的显示
	 */
	public String getName() {
		return province + " " + city + " " + district;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Set getSubareas() {
		return this.subareas;
	}

	public void setSubareas(Set subareas) {
		this.subareas = subareas;
	}

}