package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardDto;

public interface ICardsService {

	void createCard(CardDto cardDto);
	CardDto fetchCard(String mobileNumber);
	CardDto updateCard(CardDto cardDto);
	void deleteCard(String mobileNumber);
}
