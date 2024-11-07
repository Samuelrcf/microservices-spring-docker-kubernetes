package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(
		name="Cards",
		description="Schema to hold Card information")
public class CardsDto {

	@Schema(
			description="Mobile Number of the customer",
			example="4365327698")
	@NotBlank(message = "Mobile Number can not be a null or blank")
	@Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@Schema(
			description="Card Number of the customer",
			example="548732457654")
	@NotBlank(message = "Mobile Number can not be a null or blank")
	@Pattern(regexp = "^$|[0-9]{12}", message = "Card Number must be 16 digits")
	private String cardNumber;

	@Schema(
			description="Card Type of the customer",
			example="Credit Card")
	@NotBlank(message = "Card Type can not be a null.")
	private String cardType;

	@Schema(
			description="Total Limit amount",
			example="1000000")
	@NotNull(message = "Total Limit can not be a null.")
	private int totalLimit;

	@Schema(
			description="Total card amount used",
			example="1000000")
	@NotNull(message = "Amount Used can not be a null.")
	private int amountUsed;

	@Schema(
			description="Total card amount available",
			example="1000000")
	@NotNull(message = "Available can not be a null.")
	private int availableAmount;

	public CardsDto() {
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
