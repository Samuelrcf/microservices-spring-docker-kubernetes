package com.eazybytes.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;

@RestController
@RequestMapping(path="/api", produces= {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {
	
	@Autowired
	private IAccountsService iAccountsService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
		iAccountsService.createAccount(customerDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}
	
	@GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){
    	return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(iAccountsService.fetchAccount(mobileNumber));
    }
	
	@PutMapping("/update")
	public ResponseEntity<CustomerDto> updateAccountDetails(@RequestBody CustomerDto customerDto){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(iAccountsService.updateAccount(customerDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteAccount(@RequestParam String mobileNumber){
		iAccountsService.deleteAccount(mobileNumber);
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
	}
}
