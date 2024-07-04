package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDto {

	@NotBlank(message = "Name can not be a null or empty")
	@Size(min=5, max=30, message = "The length of the customer name should be between 5 and 30")
	private String name;
	
	@NotBlank(message = "Email can not be a null or empty")
	@Email(message="Email address should be a valid value")
	private String email;
	
	@Pattern(regexp="^$|[0-9]{10}", message="Mobile number must be 10 digits")
	private String mobileNumber;
	
	private AccountsDto accountsDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AccountsDto getAccountsDto() {
		return accountsDto;
	}

	public void setAccountsDto(AccountsDto accountsDto) {
		this.accountsDto = accountsDto;
	}
	
	
}
