package com.eazybytes.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Accounts extends BaseEntity{

	private Long customerId;
	
	@Id
	private Long accountNumber;
	
	private String accountType;
	
	private String branchAddress;
}
