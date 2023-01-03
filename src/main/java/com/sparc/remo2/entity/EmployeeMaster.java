package com.sparc.remo2.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "employee_master")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slno")
	private Integer slNo;
	
	@Column(name="ecode",unique = true)
	@NotNull
	private String empCode;
	
	@Column(name="emp_name")
	@NotNull
	private String empName;
	
	@ManyToOne
	@JoinColumn(name = "dept_id", nullable = false)
	private DepartmentMaster dept;
	
	@ManyToOne
	@JoinColumn(name = "etype_id", nullable = false)
	private EmployeeTypeMaster etype;
	
	@Column(name="dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Column(name="doj")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate doj;
	
	@Column(name="emp_loc")
	private String empLoc;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="imei")
	private String imei;
	
	@Column(name="emp_photo")
	private String empPhoto;
	
	@Column(name="email_offc")
	private String emailOfficial;
	
	@Column(name="email_pers")
	private String emailPersonal;
	
	@Column(name="present_addr")
	private String presentAddr;
	
	@Column(name="home_addr")
	private String homeAddr;
	
	@Column(name="aadhar_no")
	private String aadharNo;
	
	@Column(name="dl_no")
	private String dlNo;
	
	
	@DateTimeFormat(pattern="HH:mm")
	@Column(name="default_in_time")
	private LocalTime defaultInTime;
	
	@DateTimeFormat(pattern="HH:mm")
	@Column(name="default_out_time")
	private LocalTime defaultOutTime;
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public LocalTime getDefaultInTime() {
		return defaultInTime;
	}

	public void setDefaultInTime(LocalTime defaultInTime) {
		this.defaultInTime = defaultInTime;
	}

	public LocalTime getDefaultOutTime() {
		return defaultOutTime;
	}

	public void setDefaultOutTime(LocalTime defaultOutTime) {
		this.defaultOutTime = defaultOutTime;
	}

	public Integer getDeletedSts() {
		return deletedSts;
	}

	public void setDeletedSts(Integer deletedSts) {
		this.deletedSts = deletedSts;
	}
	@Column(name="created_on")
	private Date craetedOn;
	
	@Column(name="deleted_sts")
	private Integer deletedSts;


	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public DepartmentMaster getDept() {
		return dept;
	}

	public void setDept(DepartmentMaster dept) {
		this.dept = dept;
	}

	public EmployeeTypeMaster getEtype() {
		return etype;
	}

	public void setEtype(EmployeeTypeMaster etype) {
		this.etype = etype;
	}



	public String getEmpLoc() {
		return empLoc;
	}

	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getEmpPhoto() {
		return empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	public String getEmailOfficial() {
		return emailOfficial;
	}

	public void setEmailOfficial(String emailOfficial) {
		this.emailOfficial = emailOfficial;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getPresentAddr() {
		return presentAddr;
	}

	public void setPresentAddr(String presentAddr) {
		this.presentAddr = presentAddr;
	}

	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}


	public Date getCraetedOn() {
		return craetedOn;
	}

	public void setCraetedOn(Date craetedOn) {
		this.craetedOn = craetedOn;
	}
  public EmployeeMaster() {
	
   }

}
