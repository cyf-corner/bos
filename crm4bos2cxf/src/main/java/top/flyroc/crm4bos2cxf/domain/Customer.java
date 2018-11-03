package top.flyroc.crm4bos2cxf.domain;

public class Customer {

	private int id;
	private String name;
	private String station;
	private String telephone;
	private String address;
	private String decidezone_id;

	public Customer() {
	}

	public Customer(int id, String name, String station, String telephone, String address, String decidezone_id) {
		super();
		this.id = id;
		this.name = name;
		this.station = station;
		this.telephone = telephone;
		this.address = address;
		this.decidezone_id = decidezone_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDecidezone_id() {
		return decidezone_id;
	}

	public void setDecidezone_id(String decidezone_id) {
		this.decidezone_id = decidezone_id;
	}
}
