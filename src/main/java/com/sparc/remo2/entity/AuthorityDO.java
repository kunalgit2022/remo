package com.sparc.remo2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;


@Entity
@Table(name = "tbl_authority", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class AuthorityDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer Id;

	@NotNull
	private String username;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	public String getCraetedBy() {
		return craetedBy;
	}

	public void setCraetedBy(String craetedBy) {
		this.craetedBy = craetedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@NotNull
	private String password;
	
	@Value("true")
	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "created_on")
	private Date userCreationDate;
	
	@Column(name = "created_by")
	private String craetedBy;

	@Column(name = "updated_on")
	private Date updatedOn;
	
	@Column(name = "updated_by")
	private String updatedBy;
}
