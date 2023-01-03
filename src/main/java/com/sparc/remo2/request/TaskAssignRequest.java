package com.sparc.remo2.request;

public class TaskAssignRequest {
	String ecode;
	String proj;
	String comp;
	String phone;
	String stdate;
	String enddate;
	public TaskAssignRequest() {}
	public TaskAssignRequest(String ecode, String proj, String comp, String phone, String stdate, String enddate) {
		
		this.ecode = ecode;
		this.proj = proj;
		this.comp = comp;
		this.phone = phone;
		this.stdate = stdate;
		this.enddate = enddate;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getProj() {
		return proj;
	}
	public void setProj(String proj) {
		this.proj = proj;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStdate() {
		return stdate;
	}
	public void setStdate(String stdate) {
		this.stdate = stdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
}
