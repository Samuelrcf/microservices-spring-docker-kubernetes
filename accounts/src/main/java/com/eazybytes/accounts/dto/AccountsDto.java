package com.eazybytes.accounts.dto;

import java.util.UUID;

public class AccountsDto {
	
	private UUID accountNumber;
	
	private String accountType;
	
	private String branchAddress;

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
	
	
}
