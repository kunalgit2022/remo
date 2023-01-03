package com.sparc.remo2.response;

public class AssignResponse {
    String username;
    String empName;
    String ecode;
    String deptNmae;
    String deptCode;
    String defaultInTime;
    String defaultOutTime;
	public String getDefaultInTime() {
		return defaultInTime;
	}
	public void setDefaultInTime(String defaultInTime) {
		this.defaultInTime = defaultInTime;
	}
	public String getDefaultOutTime() {
		return defaultOutTime;
	}
	public void setDefaultOutTime(String defaultOutTime) {
		this.defaultOutTime = defaultOutTime;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getDeptNmae() {
		return deptNmae;
	}
	public void setDeptNmae(String deptNmae) {
		this.deptNmae = deptNmae;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
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
