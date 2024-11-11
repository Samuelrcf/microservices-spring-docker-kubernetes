package com.eazybytes.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.eazybytes.accounts.dto.LoansDto;

@FeignClient(name="loans",fallback = LoansFallback.class)
public interface LoansFeignClient {
	
	@GetMapping("/api/fetch")
	public ResponseEntity<LoansDto> fetchLoan(
			@RequestHeader("eazybank-correlation-id") String correlationId,
			@RequestParam String mobileNumber);
}
