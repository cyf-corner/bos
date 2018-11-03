package top.flyroc.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 	取派员
 */
@SuppressWarnings("all")
public class Staff implements java.io.Serializable {

	private String id;
	private String name;
	private String telephone;
	private String haspda = "0";//是否有PDA，1：有 0：无
	private String deltag = "0";//是否已删除，1：有 0：无
	private String station;
	private String standard;
	private Set decidedzones = new HashSet(0);

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

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHaspda() {
		return this.haspda;
	}

	public void setHaspda(String haspda) {
		this.haspda = haspda;
	}

	public String getDeltag() {
		return this.deltag;
	}

	public void setDeltag(String deltag) {
		this.deltag = deltag;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Set getDecidedzones() {
		return this.decidedzones;
	}

	public void setDecidedzones(Set decidedzones) {
		this.decidedzones = decidedzones;
	}

}