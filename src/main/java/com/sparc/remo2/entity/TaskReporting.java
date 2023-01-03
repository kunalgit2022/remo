package com.sparc.remo2.entity;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "task_reporting")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskReporting {
	@Id
	@Column(name = "report_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	//@DateTimeFormat(pattern="dd-MM-yyyy HH:mm a ")
	@Column(name = "reported_on")
	@NotNull
	private Timestamp reportDate;
	
	@Column(name = "sync_date")
	private Date syncDate;
	
	@Column(name = "ecode")
	@NotNull
	private String empCode;
	
	@Column(name="pcode")
	private String projCode;
	
	@Column(name="cid")
	private String compCode;
	
	@Column(name="dept_id")
	private String deptId;
	
	@Column(name="job")
	private String job;
	
	@Column(name="short_narate")
	private String shortNarrative;
	
	@Column(name="location")
	private String location;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;
	
	@DateTimeFormat(pattern="HH:mm a ")
	@Column(name="default_in_time")
	private LocalTime defaultInTime;
	
	@DateTimeFormat(pattern="HH:mm a")
	@Column(name="default_out_time")
	private LocalTime defaultOutTime;
	
	@Column(name = "photo")
	private String locationPhoto;
	
	@Column(name = "is_validate")
	private Boolean validationStatus;
	
	@Column(name = "validatedBy")
	private String validatedBy;
	
	
	
	public TaskReporting(Integer id, @NotNull Timestamp reportDate, Timestamp syncDate, @NotNull String empCode,
			String projCode, String compCode, String deptId, String job, String shortNarrative, String location,
			String quantity, double latitude, double longitude, LocalTime defaultInTime, LocalTime defaultOutTime,
			String locationPhoto, Boolean validationStatus, String validatedBy) {
		super();
		Id = id;
		this.reportDate = reportDate;
		this.syncDate = syncDate;
		this.empCode = empCode;
		this.projCode = projCode;
		this.compCode = compCode;
		this.deptId = deptId;
		this.job = job;
		this.shortNarrative = shortNarrative;
		this.location = location;
		this.quantity = quantity;
		this.latitude = latitude;
		this.longitude = longitude;
		this.defaultInTime = defaultInTime;
		this.defaultOutTime = defaultOutTime;
		this.locationPhoto = locationPhoto;
		this.validationStatus = validationStatus;
		this.validatedBy = validatedBy;
	}


	public Date getSyncDate() {
		return syncDate;
	}


	public void setSyncDate(Date syncDate) {
		this.syncDate = syncDate;
	}


	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}

	public Timestamp getReportDate() {
		return reportDate;
	}
	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
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
	public String getShortNarrative() {
		return shortNarrative;
	}
	public void setShortNarrative(String shortNarrative) {
		this.shortNarrative = shortNarrative;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
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
	public String getLocationPhoto() {
		return locationPhoto;
	}
	public void setLocationPhoto(String locationPhoto) {
		this.locationPhoto = locationPhoto;
	}
	public Boolean getValidationStatus() {
		return validationStatus;
	}
	public void setValidationStatus(Boolean validationStatus) {
		this.validationStatus = validationStatus;
	}
	public String getValidatedBy() {
		return validatedBy;
	}
	public void setValidatedBy(String validatedBy) {
		this.validatedBy = validatedBy;
	}
	public TaskReporting() {}
	
	
}
