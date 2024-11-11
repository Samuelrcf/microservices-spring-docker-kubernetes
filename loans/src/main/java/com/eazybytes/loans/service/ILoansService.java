package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoansDto;

public interface ILoansService {

	void create (String mobileNumber);
	LoansDto fetch (String mobileNumber);
	LoansDto update (LoansDto loansDto);
	void delete (String mobileNumber);
}
