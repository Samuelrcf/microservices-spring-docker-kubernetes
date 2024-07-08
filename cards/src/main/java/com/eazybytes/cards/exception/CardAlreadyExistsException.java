package com.eazybytes.cards.exception;

public class CardAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CardAlreadyExistsException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with the given input data %s: '%s'", resourceName, fieldName, fieldValue));
	}
}
