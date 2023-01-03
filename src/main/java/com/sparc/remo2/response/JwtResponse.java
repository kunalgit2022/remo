package com.sparc.remo2.response;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String empName;
	private String ecode;
	private String deptName;
	private String deptid;
	private String inTime;
	private String outTime;

	public JwtResponse(String token, String username, String empName, String ecode, String deptName, String deptid,
			String inTime, String outTime) {
		this.token = token;
		this.username = username;
		this.empName = empName;
		this.ecode = ecode;
		this.deptName = deptName;
		this.deptid = deptid;
		this.inTime = inTime;
		this.outTime = outTime;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
