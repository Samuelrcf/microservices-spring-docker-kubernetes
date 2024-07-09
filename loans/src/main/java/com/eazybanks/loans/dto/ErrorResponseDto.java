package com.eazybanks.loans.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponseDto {

	private String apiPath;
	private HttpStatus errorCode;
	private String errorMessage;
	private LocalDateTime errorOccurred;

	public ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorOccurred) {
		this.apiPath = apiPath;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorOccurred = errorOccurred;
	}

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getErrorOccurred() {
		return errorOccurred;
	}

	public void setErrorOccurred(LocalDateTime errorOccurred) {
		this.errorOccurred = errorOccurred;
	}

}
