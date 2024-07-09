package com.eazybanks.loans.service;

import com.eazybanks.loans.dto.LoansDto;

public interface ILoansService {

	void create (LoansDto loansDto);
	LoansDto fetch (String mobileNumber);
	LoansDto update (LoansDto loansDto);
	void delete (String mobileNumber);
}
