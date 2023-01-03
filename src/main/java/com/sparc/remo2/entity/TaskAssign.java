package com.sparc.remo2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "task_assign")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskAssign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slno")
	private Integer slNo;

	@Column(name="ecode")
	@NotNull
	private String empCode;
	
	@Column(name="phone")
	@NotNull
	private String phone;
	
	@Column(name="pcode")
	@NotNull
	private String projCode;
	
	@Column(name="cid")
	@NotNull
	private String compCode;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "pcode",referencedColumnName = "pcode",nullable = false)
	 * private ProjectMaster proj;
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "cid",referencedColumnName = "cid",nullable = false)
	 * private ComponentMaster comp;
	 */
	
	@Column(name="start_dt")
	private Date startDate;
	
	@Column(name="end_dt")
	private Date endDate;
	
	@Column(name="created_on")
	private Date craetedOn;
	
	@Value("true")
	@Column(name = "is_active")
	private boolean isActive;
	public TaskAssign() {}
	public TaskAssign(Integer slNo, @NotNull String empCode, @NotNull String phone, @NotNull String projCode,
			@NotNull String compCode, Date startDate, Date endDate, Date craetedOn, boolean isActive) {
		super();
		this.slNo = slNo;
		this.empCode = empCode;
		this.phone = phone;
		this.projCode = projCode;
		this.compCode = compCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.craetedOn = craetedOn;
		this.isActive = isActive;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCraetedOn() {
		return craetedOn;
	}

	public void setCraetedOn(Date craetedOn) {
		this.craetedOn = craetedOn;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
