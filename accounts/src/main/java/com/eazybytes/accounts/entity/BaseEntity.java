package com.eazybytes.accounts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Column(updatable = false)
	private LocalDateTime createdAt;
	@Column(updatable = false)
	private String createdBy;
	@Column(insertable = false)
	private LocalDateTime updateAt;
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
