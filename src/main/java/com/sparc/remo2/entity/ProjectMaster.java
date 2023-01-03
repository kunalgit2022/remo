package com.sparc.remo2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name = "project_master")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectMaster implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slno")
	private Integer slNo;
	
	@Column(name="pcode",unique = true)
	@NotNull
	private String projCode;
	
	@Column(name="proj_name",unique = true)
	@NotNull
	private String projName;
	
	@Column(name="pdesc")
	private String projDesc;
	
	@Column(name="client_name")
	private String clientName;

	@ManyToOne
	@JoinColumn(name = "dept_id", nullable = false)
	private DepartmentMaster dept;
	
	@ManyToOne
	@JoinColumn(name = "sts_id", nullable = false)
	private StatusMaster status;
	
	@Column(name="start_dt")
	private Date startDate;
	
	@Column(name="end_dt")
	private Date endDate;
	
	@Column(name="created_on")
	private Date craetedOn;
	
	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public String getProjDesc() {
		return projDesc;
	}

	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public DepartmentMaster getDept() {
		return dept;
	}

	public void setDept(DepartmentMaster dept) {
		this.dept = dept;
	}

	public StatusMaster getStatus() {
		return status;
	}

	public void setStatus(StatusMaster status) {
		this.status = status;
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

	public ProjectMaster(Integer slNo, @NotNull String projCode, @NotNull String projDesc, String clientName,
			String projName, DepartmentMaster dept, StatusMaster status, Date startDate, Date endDate, Date craetedOn) {
		super();
		this.slNo = slNo;
		this.projCode = projCode;
		this.projDesc = projDesc;
		this.clientName = clientName;
		this.projName = projName;
		this.dept = dept;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.craetedOn = craetedOn;
	}
	public ProjectMaster() {
		
	}
}
