package com.eazybytes.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eazybytes.accounts.dto.CardsDto;

@FeignClient(name="cards",fallback = CardsFallback.class)
public interface CardsFeignClient {
	
	@GetMapping("/api/fetch")
	public ResponseEntity<CardsDto> fetchCard(@RequestParam String mobileNumber);
}
