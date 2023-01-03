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
@Table(name = "holiday_master")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HolidayMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hid")
	private Integer hId;
	
	@Column(name="hdate")
	private Date hDate;
	
	@Column(name="hdesc")
	private String holidayDesc;
	
	@Column(name="branch_loc")
	private String branchLoc;
	
	@Column(name="htype")
	private String holidayType;
	
	@Column(name="weekday")
	private String weekday;
	
	@Column(name="created_on")
	private Date craetedOn;

	public Integer gethId() {
		return hId;
	}

	public void sethId(Integer hId) {
		this.hId = hId;
	}

	public Date gethDate() {
		return hDate;
	}

	public void sethDate(Date hDate) {
		this.hDate = hDate;
	}

	public String getHolidayDesc() {
		return holidayDesc;
	}

	public void setHolidayDesc(String holidayDesc) {
		this.holidayDesc = holidayDesc;
	}

	public String getBranchLoc() {
		return branchLoc;
	}

	public void setBranchLoc(String branchLoc) {
		this.branchLoc = branchLoc;
	}

	public String getHolidayType() {
		return holidayType;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public Date getCraetedOn() {
		return craetedOn;
	}

	public void setCraetedOn(Date craetedOn) {
		this.craetedOn = craetedOn;
	}

	public HolidayMaster() {
		
	}
	public HolidayMaster(Integer hId, Date hDate, String holidayDesc, String branchLoc, String holidayType,
			String weekday, Date craetedOn) {
		super();
		this.hId = hId;
		this.hDate = hDate;
		this.holidayDesc = holidayDesc;
		this.branchLoc = branchLoc;
		this.holidayType = holidayType;
		this.weekday = weekday;
		this.craetedOn = craetedOn;
	}

}
