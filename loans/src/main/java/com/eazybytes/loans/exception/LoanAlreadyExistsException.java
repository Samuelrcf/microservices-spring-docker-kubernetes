package com.eazybytes.loans.exception;

public class LoanAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public LoanAlreadyExistsException(String message) {
		super(message);
	}
}
