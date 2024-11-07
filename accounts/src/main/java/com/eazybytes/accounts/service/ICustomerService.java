package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

	CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
	
}
