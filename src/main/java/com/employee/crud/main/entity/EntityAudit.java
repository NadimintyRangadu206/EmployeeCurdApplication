package com.employee.crud.main.entity;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;

@EntityListeners(AuditingEntityListener.class)
public class EntityAudit implements Serializable {

	private static final long serialVersionUID =1L;

	@JsonIgnore
	@Column(name = "created_by")
	private String createdBy;
	@CreationTimestamp
	@JsonIgnore
	@Column(name = "created_dt")
	private Date createdDate;

	@JsonIgnore
	@Column(name = "updated_by")
	private String updatedBy;
	@UpdateTimestamp
	@JsonIgnore
	@Column(name = "updated_dt")
	private Date updatedDate;

	@Column(name = "is_active")
	private String isActive;

	public EntityAudit() {
		super();
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate(java.util.Date date) {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "EntityAudit [createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}
}
