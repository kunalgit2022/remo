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

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "component_master")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComponentMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slno")
	private Integer slNo;
	
	@Column(name="cid",unique = true)
	@NotNull
	@NaturalId
	private String compCode;

	@Column(name="bill_comp")
	@NotNull
	private String billComp;
	
	@Column(name="unit_measure")
	private Double unitMeasure;
	
	@Column(name="comp_value")
	private Double compValue;
	
	@Column(name="md_estimate")
	private Double mdEstimate;
	
	@ManyToOne
    @JoinColumn(name = "pcode",referencedColumnName = "pcode",nullable = false)
	private ProjectMaster proj;
	
	@ManyToOne
	@JoinColumn(name = "sts_id", nullable = false)
	private StatusMaster status;

	@Column(name="created_on")
	private Date craetedOn;
	
	@Column(name="start_dt")
	private Date startDate;
	
	@Column(name="end_dt")
	private Date endDate;
	
	public ComponentMaster() {}
	public ComponentMaster(Integer slNo, @NotNull String compCode, @NotNull String billComp, Double unitMeasure,
			Double compValue, Double mdEstimate, ProjectMaster proj, StatusMaster status, Date craetedOn,
			Date startDate, Date endDate) {
		this.slNo = slNo;
		this.compCode = compCode;
		this.billComp = billComp;
		this.unitMeasure = unitMeasure;
		this.compValue = compValue;
		this.mdEstimate = mdEstimate;
		this.proj = proj;
		this.status = status;
		this.craetedOn = craetedOn;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Integer getSlNo() {
		return slNo;
	}
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
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

	public String getBillComp() {
		return billComp;
	}

	public void setBillComp(String billComp) {
		this.billComp = billComp;
	}

	public Double getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(Double unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public Double getCompValue() {
		return compValue;
	}

	public void setCompValue(Double compValue) {
		this.compValue = compValue;
	}

	public Double getMdEstimate() {
		return mdEstimate;
	}

	public void setMdEstimate(Double mdEstimate) {
		this.mdEstimate = mdEstimate;
	}

	public ProjectMaster getProj() {
		return proj;
	}

	public void setProj(ProjectMaster proj) {
		this.proj = proj;
	}

	public StatusMaster getStatus() {
		return status;
	}

	public void setStatus(StatusMaster status) {
		this.status = status;
	}

	public Date getCraetedOn() {
		return craetedOn;
	}

	public void setCraetedOn(Date craetedOn) {
		this.craetedOn = craetedOn;
	}

	

}

