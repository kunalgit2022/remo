package com.sparc.remo2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "department_master")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentMaster {

	@Id
	/* @GeneratedValue(strategy = GenerationType.IDENTITY) */
	@Column(name="dept_id")
	private String DeptId;
	
	@Column(name="dept_name",unique = true)
	@NotNull
	private String DeptName;
	
	@Column(name="dept_desc")
	private String DeptDesc;

	public DepartmentMaster() {}
	public DepartmentMaster(String deptId, @NotNull String deptName, String deptDesc) {
		super();
		DeptId = deptId;
		DeptName = deptName;
		DeptDesc = deptDesc;
	}

	public String getDeptId() {
		return DeptId;
	}

	public void setDeptId(String deptId) {
		DeptId = deptId;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getDeptDesc() {
		return DeptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		DeptDesc = deptDesc;
	}
	
	
}

