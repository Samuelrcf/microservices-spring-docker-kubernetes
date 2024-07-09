package com.eazybytes.cards.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CardDto {

	@NotBlank(message = "Mobile Number can not be a null or blank")
	@Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@NotBlank(message = "Mobile Number can not be a null or blank")
	@Pattern(regexp = "^$|[0-9]{12}", message = "Card Number must be 16 digits")
	private String cardNumber;

	@NotBlank(message = "Card Type can not be a null.")
	private String cardType;

	@NotNull(message = "Total Limit can not be a null.")
	private int totalLimit;

	@NotNull(message = "Amount Used can not be a null.")
	private int amountUsed;

	@NotNull(message = "Available can not be a null.")
	private int availableAmount;

	public CardDto() {
	}

	public CardDto(
			@NotBlank(message = "Mobile Number can not be a null or blank") @Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits") String mobileNumber,
			@NotBlank(message = "Mobile Number can not be a null or blank") @Pattern(regexp = "^$|[0-9]{12}", message = "Card Number must be 12 digits") String cardNumber,
			@NotBlank(message = "Card Type can not be a null.") String cardType,
			@NotNull(message = "Total Limit can not be a null.") int totalLimit,
			@NotNull(message = "Amount Used can not be a null.") int amountUsed,
			@NotNull(message = "Available can not be a null.") int availableAmount) {
		this.mobileNumber = mobileNumber;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.totalLimit = totalLimit;
		this.amountUsed = amountUsed;
		this.availableAmount = availableAmount;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(int totalLimit) {
		this.totalLimit = totalLimit;
	}

	public int getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(int amountUsed) {
		this.amountUsed = amountUsed;
	}

	public int getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}

}
