package com.eazybanks.loans.service;

import com.eazybanks.loans.dto.LoansDto;

public interface ILoansService {

	void create (String mobileNumber);
	LoansDto fetch (String mobileNumber);
	LoansDto update (LoansDto loansDto);
	void delete (String mobileNumber);
}
