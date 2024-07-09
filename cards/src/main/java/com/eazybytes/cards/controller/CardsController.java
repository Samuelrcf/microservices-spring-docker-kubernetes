package com.eazybytes.cards.controller;

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

import com.eazybytes.cards.constants.CardsConstants;
import com.eazybytes.cards.dto.CardDto;
import com.eazybytes.cards.dto.ResponseDto;
import com.eazybytes.cards.service.ICardsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
@Tag(
		name="CRUD REST API for Cards in SRBank",
		description="CRUD REST API in SRBank to CREATE, UPDATE, FETCH AND DELETE cards details")
public class CardsController {

	@Autowired
	ICardsService cardsService;
	
	@Operation(
			summary = "Create Cards REST API",
			description = "REST API to create new Cards inside SRBank")
	@ApiResponse(
			responseCode="201",
			description="HTTP Status CREATED")
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createCard(
			@RequestParam @NotBlank(message = "Mobile number cannot be empty") @Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits") String mobileNumber) {
		cardsService.createCard(mobileNumber);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
	}

	@Operation(
			summary = "Fetch Cards details REST API",
			description = "REST API to fetch card details")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
	@GetMapping("/fetch")
	public ResponseEntity<CardDto> fetchCard(
			@RequestParam @NotBlank(message = "Mobile number cannot be empty") @Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits") String mobileNumber) {
		return ResponseEntity.status(HttpStatus.OK).body(cardsService.fetchCard(mobileNumber));
	}

	@Operation(
			summary = "Update Cards details REST API",
			description = "REST API to update card details")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status OK")
	@PutMapping("/update")
	public ResponseEntity<CardDto> updateCard(@Valid @RequestBody CardDto cardDto) {
		return ResponseEntity.status(HttpStatus.OK).body(cardsService.updateCard(cardDto));
	}

	@Operation(
			summary = "Delete Cards REST API",
			description = "REST API to delete card inside SRBank")
	@ApiResponse(
			responseCode="204",
			description="HTTP Status No CONTENT")
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteCard(
			@RequestParam @NotBlank(message = "Mobile number cannot be empty") @Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits") String mobileNumber) {
		cardsService.deleteCard(mobileNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
