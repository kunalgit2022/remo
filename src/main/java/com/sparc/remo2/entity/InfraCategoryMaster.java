package com.sparc.remo2.entity;

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
@Table(name = "infra_category_master")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfraCategoryMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ctg_id")
	private Integer ctgId;
	
	@Column(name="ctg_name",unique = true)
	@NotNull
	private String categoryName;

	public Integer getCtgId() {
		return ctgId;
	}

	public InfraCategoryMaster() {
		
	}
	public InfraCategoryMaster(Integer ctgId, @NotNull String categoryName) {
	
		this.ctgId = ctgId;
		this.categoryName = categoryName;
	}

	public void setCtgId(Integer ctgId) {
		this.ctgId = ctgId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
