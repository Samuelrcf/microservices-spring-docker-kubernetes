package com.eazybytes.accounts.controller;

import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsContactInfoDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Tag(
	name="CRUD REST API for Accounts in SRBank",
	description="CRUD REST API in SRBank to CREATE, UPDATE, FETCH AND DELETE account details")
@RestController
@RequestMapping(path="/api", produces= {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);
	
	private IAccountsService iAccountsService;
	
	@Value("${build.version}")
	private String buildVersion;
	
	private Environment environment;
	
	private AccountsContactInfoDto accountsContactInfoDto;

	public AccountsController(IAccountsService iAccountsService, Environment environment, AccountsContactInfoDto accountsContactInfoDto) {
		this.iAccountsService = iAccountsService;
		this.environment = environment;
		this.accountsContactInfoDto = accountsContactInfoDto;
	}
	
	@Operation(
			summary = "Create Account REST API",
			description = "REST API to create new Customer & Account inside SRBank")
	@ApiResponse(
			responseCode="201",
			description="HTTP Status CREATED")
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
		iAccountsService.createAccount(customerDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}
	
	@Operation(
			summary = "Fetch Account Details REST API",
			description = "REST API to fetch Customer & Account based on a mobile number inside SRBank")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
	@GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(
    		@RequestParam @Pattern(regexp="^$|[0-9]{10}", message="Mobile number must be 10 digits") String mobileNumber){
    	return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(iAccountsService.fetchAccount(mobileNumber));
    }
	
	@Operation(
			summary = "Update Account Details REST API",
			description = "REST API to update Customer & Account base on a account number inside SRBank")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
	@PutMapping("/update")
	public ResponseEntity<CustomerDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(iAccountsService.updateAccount(customerDto));
	}
	
	@Operation(
			summary = "Delete Account Details REST API",
			description = "REST API to delete Customer & Account base on a mobile number inside SRBank")
	@ApiResponse(
			responseCode="204",
			description="HTTP Status NO CONTENT")
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteAccount(
			@RequestParam @Pattern(regexp="^$|[0-9]{10}", message="Mobile number must be 10 digits") String mobileNumber){
		iAccountsService.deleteAccount(mobileNumber);
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
	}
	
	@Operation(
			summary = "Get Build Information",
			description = "Get Build Information that is deployed into accounts microservice")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
	@Retry(name = "getBuildInfo",fallbackMethod = "getBuildInfoFallback")
	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildInfo() throws TimeoutException{
		logger.debug("getBuildInfo() method Invoked");
		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	}
	
	public ResponseEntity<String> getBuildInfoFallback(Throwable throwable){ //precisa aceitar o msm numero de parametros + throwable
		logger.debug("getBuildInfoFallback() method Invoked");
		return ResponseEntity.status(HttpStatus.OK).body("0.9");
	}
	
	@Operation(
			summary = "Get Number Of Processors",
			description = "Get number of processors on the machine")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
	@RateLimiter(name= "getProcessors", fallbackMethod = "getProcessorsFallback")
	@GetMapping("/processors")
	public ResponseEntity<String> getProcessors(){
		return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("NUMBER_OF_PROCESSORS"));
	}
	
	public ResponseEntity<String> getProcessorsFallback(Throwable throwable){
		return ResponseEntity.status(HttpStatus.OK).body("4");
	}
	
	@Operation(
			summary = "Get Contact Info",
			description = "Contact Info details that can be reached out in case of any issues")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
	@GetMapping("/contact-info")
	public ResponseEntity<AccountsContactInfoDto> getContactInfo(){
		return ResponseEntity.status(HttpStatus.OK).body(accountsContactInfoDto);
	}
}
