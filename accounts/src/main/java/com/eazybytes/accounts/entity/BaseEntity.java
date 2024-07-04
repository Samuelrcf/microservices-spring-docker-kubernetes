package com.eazybytes.accounts.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@CreatedBy
	@Column(updatable = false)
	private String createdBy;
	
	@LastModifiedDate
	@Column(insertable = false)
	private LocalDateTime updateAt;
	
	@LastModifiedBy
	@Column(insertable = false)
	private String updateBy;

	public BaseEntity() {
	}

	public BaseEntity(LocalDateTime createdAt, String createdBy, LocalDateTime updateAt, String updateBy) {
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updateAt = updateAt;
		this.updateBy = updateBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public String toString() {
		return "BaseEntity [createdAt=" + createdAt + ", createdBy=" + createdBy + ", updateAt=" + updateAt
				+ ", updateBy=" + updateBy + "]";
	}

}
