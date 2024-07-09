package com.eazybanks.loans.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eazybanks.loans.constants.LoansConstants;
import com.eazybanks.loans.dto.LoansDto;
import com.eazybanks.loans.entity.Loans;
import com.eazybanks.loans.exception.LoanAlreadyExistsException;
import com.eazybanks.loans.exception.ResourceNotFoundException;
import com.eazybanks.loans.mapper.LoansMapper;
import com.eazybanks.loans.repository.LoansRepository;
import com.eazybanks.loans.service.ILoansService;

@Service
public class LoansService implements ILoansService{
	
	@Autowired
	LoansRepository loansRepository;

	@Override
	public void create(String mobileNumber) {
		if(loansRepository.findLoansByMobileNumber(mobileNumber).isPresent()) {
			throw new LoanAlreadyExistsException("Loan already registered with given mobile number " + mobileNumber);
		}
		Loans loan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        loan.setLoanNumber(Long.toString(randomLoanNumber));
		loan.setAmountPaid(0);
		loan.setLoanType(LoansConstants.HOME_LOAN);
		loan.setMobileNumber(mobileNumber);
		loan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
		loan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
		loansRepository.save(loan);
	}

	@Override
	public LoansDto fetch(String mobileNumber) {
		Loans loans = loansRepository.findLoansByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Loans", "Mobile Number", mobileNumber));
		return LoansMapper.loanToLoanDto(loans);
	}

	@Override
	public LoansDto update(LoansDto loansDto) {
		Loans loans = loansRepository.findLoansByLoanNumber(loansDto.getLoanNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Loans", "Loan Number", loansDto.getLoanNumber()));
		LoansMapper.loanDtoToLoan(loansDto, loans);
		loansRepository.save(loans);
		return LoansMapper.loanToLoanDto(loans);
	}

	@Override
	public void delete(String mobileNumber) {
		Loans loans = loansRepository.findLoansByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Loans", "Mobile Number", mobileNumber));
		loansRepository.delete(loans);
	}
	
}
