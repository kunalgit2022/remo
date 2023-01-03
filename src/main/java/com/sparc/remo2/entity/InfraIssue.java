package com.sparc.remo2.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "infra_issue")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfraIssue {
	@Id
	@Column(name = "issue_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(name = "reported_on")
	@NotNull
	private Timestamp reportDate;
	
	@Column(name = "ecode")
	@NotNull
	private String empCode;

	@Column(name="category")
	@NotNull
	private String category;
	
	private String issue;
	
	public InfraIssue() {
		
	}


	public InfraIssue(Integer id, @NotNull Timestamp reportDate, @NotNull String empCode, @NotNull String category,
			String issue, String description) {
		Id = id;
		this.reportDate = reportDate;
		this.empCode = empCode;
		this.category = category;
		this.issue = issue;
		this.description = description;
	}


	public Timestamp getReportDate() {
		return reportDate;
	}


	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}



	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;
}
