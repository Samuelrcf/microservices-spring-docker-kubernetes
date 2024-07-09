package com.eazybanks.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(name = "Loans", description = "Schema to hold Loan information")
public class LoansDto {

	@Schema(description = "Mobile Number of SR Bank loan", example = "1234567890")
	@NotBlank(message = "Mobile Number can not be a null or blank")
	@Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@Schema(description = "Loan Number of SR Bank account", example = "548732457654")
	@NotBlank(message = "Loan Number can not be a null or blank")
	@Pattern(regexp = "^$|[0-9]{12}", message = "Mobile number must be 10 digits")
	private String loanNumber;

	@Schema(description = "Type of the loan", example = "Home Loan")
	@NotBlank(message = "Loan Type can not be a null or blank.")
	private String loanType;

	@Schema(description = "Total loan amount", example = "100000")
	@Positive(message = "Total Loan should be greater than zero")
	private int totalLoan;

	@Schema(description = "Total loan amount paid", example = "1000")
	@PositiveOrZero(message = "Amount Paid should be greater or equal than zero")
	private int amountPaid;

	@Schema(description = "Total outstanding amount against a loan", example = "99000")
	@PositiveOrZero(message = "Outstanding Amount should be greater or equal than zero")
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
