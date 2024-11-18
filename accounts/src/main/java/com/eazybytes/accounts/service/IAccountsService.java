package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

	void createAccount(CustomerDto customerDto);
	CustomerDto fetchAccount(String mobileNumber);
	CustomerDto updateAccount(CustomerDto customerDto);
	void deleteAccount(String mobileNumber);
	boolean updateCommunicationStatus(Long accountNumber);
	
}
