package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class AccountsDto {
	
	@NotBlank(message = "AccountNumber can not be a null or empty")
	@Pattern(regexp="^$|[0-9]{10}", message="Mobile number must be 10 digits")
	private Long accountNumber;
	
	@NotBlank(message = "AccountType can not be a null or empty")
	private String accountType;
	
	@NotEmpty(message = "BranchAddress can not be a null or empty")
	private String branchAddress;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
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
