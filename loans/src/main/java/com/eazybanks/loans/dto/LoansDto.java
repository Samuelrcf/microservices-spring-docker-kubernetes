package com.eazybanks.loans.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LoansDto {

	@Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@Pattern(regexp = "^$|[0-9]{16}", message = "Mobile number must be 10 digits")
	private String loanNumber;

	@NotBlank(message = "Loan Type can not be a null or blank.")
	private String loanType;

	@NotNull(message = "Loan Type can not be a null.")
	private int totalLoan;

	@NotNull(message = "Amount Paid can not be a null.")
	private int amountPaid;

	@NotNull(message = "Outstanding Amount can not be a null.")
	private int outstandingAmount;

	public LoansDto() {
	}

	public LoansDto(@Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits") String mobileNumber,
			@Pattern(regexp = "^$|[0-9]{16}", message = "Mobile number must be 10 digits") String loanNumber,
			@NotBlank(message = "Loan Type can not be a null or blank.") String loanType,
			@NotNull(message = "Loan Type can not be a null.") int totalLoan,
			@NotNull(message = "Amount Paid can not be a null.") int amountPaid,
			@NotNull(message = "Outstanding Amount can not be a null.") int outstandingAmount) {
		this.mobileNumber = mobileNumber;
		this.loanNumber = loanNumber;
		this.loanType = loanType;
		this.totalLoan = totalLoan;
		this.amountPaid = amountPaid;
		this.outstandingAmount = outstandingAmount;
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
