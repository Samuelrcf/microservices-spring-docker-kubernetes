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

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class LoansController {
    
    @Autowired
    ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoans(@RequestParam @NotBlank(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits") String mobileNumber){
        iLoansService.create(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoans(
            @RequestParam @NotBlank(message = "Mobile number cannot be empty")
            @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits") String mobileNumber) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(iLoansService.fetch(mobileNumber));
    }
    
    @PutMapping("/update")
    public ResponseEntity<LoansDto> updateLoans(@Valid @RequestBody LoansDto loansDto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(iLoansService.update(loansDto));
    }
    
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
