package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(
		name="Accounts",
		description="Schema to hold Account information")
public class AccountsDto {
	
	
	@Schema(description="Account Number of SR Bank account",
			example="1234567890")
	@NotBlank(message = "AccountNumber can not be a null or empty")
	@Pattern(regexp="^$|[0-9]{10}", message="Mobile number must be 10 digits")
	private Long accountNumber;
	
	@Schema(description="Account type of SR Bank account",
			example="Savings")
	@NotBlank(message = "AccountType can not be a null or empty")
	private String accountType;
	
	@Schema(description="SR Bank branch address",
			example="123 Fortaleza")
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
