package com.eazybanks.loans.mapper;

import com.eazybanks.loans.dto.LoansDto;
import com.eazybanks.loans.entity.Loans;

public class LoansMapper {

	static public Loans loanDtoToLoan (LoansDto loansDto) {
		Loans loans = new Loans();
		loans.setAmountPaid(loansDto.getAmountPaid());
		loans.setLoanNumber(loansDto.getLoanNumber());
		loans.setLoanType(loansDto.getLoanType());
		loans.setMobileNumber(loansDto.getMobileNumber());
		loans.setOutstandingAmount(loansDto.getOutstandingAmount());
		loans.setTotalLoan(loansDto.getTotalLoan());
		return loans;
	}
	
	static public LoansDto loanToLoanDto (Loans loans) {
		LoansDto loansDto = new LoansDto();
		loansDto.setAmountPaid(loans.getAmountPaid());
		loansDto.setLoanNumber(loans.getLoanNumber());
		loansDto.setLoanType(loans.getLoanType());
		loansDto.setMobileNumber(loans.getMobileNumber());
		loansDto.setOutstandingAmount(loans.getOutstandingAmount());
		loansDto.setTotalLoan(loans.getTotalLoan());
		return loansDto;
	}
}
