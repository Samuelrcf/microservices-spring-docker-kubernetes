package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardDto;

public interface ICardsService {

	void createCard(String mobileNumber);
	CardDto fetchCard(String mobileNumber);
	CardDto updateCard(CardDto cardDto);
	void deleteCard(String mobileNumber);
}
