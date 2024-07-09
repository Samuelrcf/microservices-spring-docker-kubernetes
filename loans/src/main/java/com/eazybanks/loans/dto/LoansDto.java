package com.eazybanks.loans.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class LoansDto {

	@NotBlank(message = "Mobile Number can not be a null or blank")
	@Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@NotBlank(message = "Mobile Number can not be a null or blank")
	@Pattern(regexp = "^$|[0-9]{12}", message = "Mobile number must be 10 digits")
	private String loanNumber;

	@NotBlank(message = "Loan Type can not be a null or blank.")
	private String loanType;

	@Positive(message="Total Loan should be greater than zero")
	private int totalLoan;

	@PositiveOrZero(message="Amount Paid should be greater or equal than zero")
	private int amountPaid;

	@PositiveOrZero(message="Outstanding Amount should be greater or equal than zero")
	private int outstandingAmount;

	public LoansDto() {
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(int totalLoan) {
		this.totalLoan = totalLoan;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(int outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

}
