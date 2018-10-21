package top.flyroc.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleVisit {

	private String visit_id;
	private String visit_interviewee;
	private String visit_addr;
	private String visit_detail;
	private Date visit_time;
	private Date visit_nexttime;

	// 表达所属客户对象 多对一
	private Customer customer;
	// 表达所属用户对象 多对一
	private User user;

	public String getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}

	public String getVisit_interviewee() {
		return visit_interviewee;
	}

	public void setVisit_interviewee(String visit_interviewee) {
		this.visit_interviewee = visit_interviewee;
	}

	public String getVisit_addr() {
		return visit_addr;
	}

	public void setVisit_addr(String visit_addr) {
		this.visit_addr = visit_addr;
	}

	public String getVisit_detail() {
		return visit_detail;
	}

	public void setVisit_detail(String visit_detail) {
		this.visit_detail = visit_detail;
	}

	public Date getVisit_time() {
		return visit_time;
	}

	public Date getVisit_nexttime() {
		return visit_nexttime;
	}

	// -----------------------------------------------
	public String getVisit_time_s() {
		return transferDate(visit_time, "yyyy-MM-dd");
	}

	public String getVisit_nexttime_s() {
		return transferDate(visit_nexttime, "yyyy-MM-dd");
	}

	public static String transferDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	// -----------------------------------------------
	public void setVisit_time(Date visit_time) {
		this.visit_time = visit_time;
	}

	public void setVisit_nexttime(Date visit_nexttime) {
		this.visit_nexttime = visit_nexttime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
