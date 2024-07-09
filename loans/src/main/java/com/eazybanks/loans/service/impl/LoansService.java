package com.eazybanks.loans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void create(LoansDto loansDto) {
		if(loansRepository.findLoansByMobileNumber(loansDto.getMobileNumber()).isPresent()) {
			throw new LoanAlreadyExistsException("Loan already registered with given mobile number " + loansDto.getMobileNumber());
		}
		Loans loans = LoansMapper.loanDtoToLoan(loansDto);
		loansRepository.save(loans);
	}

	@Override
	public LoansDto fetch(String mobileNumber) {
		Loans loans = loansRepository.findLoansByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Loans", "Mobile Number", mobileNumber));
		return LoansMapper.loanToLoanDto(loans);
	}

	@Override
	public LoansDto update(LoansDto loansDto) {
		Loans loans = loansRepository.findLoansByMobileNumber(loansDto.getMobileNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Loans", "Mobile Number", loansDto.getMobileNumber()));
		
		loans.setAmountPaid(loansDto.getAmountPaid());
		loans.setLoanNumber(loansDto.getLoanNumber());
		loans.setLoanType(loansDto.getLoanType());
		loans.setMobileNumber(loansDto.getMobileNumber());
		loans.setOutstandingAmount(loansDto.getOutstandingAmount());
		loans.setTotalLoan(loansDto.getTotalLoan());
		
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
