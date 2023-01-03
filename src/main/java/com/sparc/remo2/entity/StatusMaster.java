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
@Table(name = "status_master")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sts_id")
	private Integer stsId;
	
	@Column(name="sts_name",unique = true)
	@NotNull
	private String statusName;
	
	public StatusMaster() {
		
	}
	public StatusMaster(Integer stsId, @NotNull String statusName) {
		super();
		this.stsId = stsId;
		this.statusName = statusName;
	
	}

	public Integer getStsId() {
		return stsId;
	}

	public void setStsId(Integer stsId) {
		this.stsId = stsId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
