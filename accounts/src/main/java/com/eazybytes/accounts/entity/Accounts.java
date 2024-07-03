package com.eazybytes.accounts.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Accounts extends BaseEntity{

	private Long customerId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID accountNumber;
	
	private String accountType;
	
	private String branchAddress;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public UUID getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(UUID accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	@Override
	public String toString() {
		return "Accounts [customerId=" + customerId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", branchAddress=" + branchAddress + "]";
	}
	
	
}
