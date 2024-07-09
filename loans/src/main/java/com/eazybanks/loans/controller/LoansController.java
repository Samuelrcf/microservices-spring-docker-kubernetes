package com.eazybanks.loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybanks.loans.constants.LoansConstants;
import com.eazybanks.loans.dto.LoansDto;
import com.eazybanks.loans.dto.ResponseDto;
import com.eazybanks.loans.service.ILoansService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Tag(
		name="CRUD REST API for Loans in SRBank",
		description="CRUD REST API in SRBank to CREATE, UPDATE, FETCH AND DELETE loans details")
@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class LoansController {
    
    @Autowired
    ILoansService iLoansService;

	@Operation(
			summary = "Create Loan REST API",
			description = "REST API to create new loan inside SRBank")
	@ApiResponse(
			responseCode="201",
			description="HTTP Status CREATED")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoans(@RequestParam @NotBlank(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits") String mobileNumber){
        iLoansService.create(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }
    
	@Operation(
			summary = "Fetch Loan REST API",
			description = "REST API to fetch loan details inside SRBank")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoans(
            @RequestParam @NotBlank(message = "Mobile number cannot be empty")
            @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits") String mobileNumber) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(iLoansService.fetch(mobileNumber));
    }
    
	@Operation(
			summary = "Update Loan REST API",
			description = "REST API to update loan details")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
    @PutMapping("/update")
    public ResponseEntity<LoansDto> updateLoans(@Valid @RequestBody LoansDto loansDto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(iLoansService.update(loansDto));
    }
    
	@Operation(
			summary = "Delete Loan REST API",
			description = "REST API to delete loan inside SRBank")
	@ApiResponse(
			responseCode="204",
			description="HTTP Status NO CONTENT")
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteLoans(
            @RequestParam @NotBlank(message = "Mobile number cannot be empty")
            @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits") String mobileNumber) {
        iLoansService.delete(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
