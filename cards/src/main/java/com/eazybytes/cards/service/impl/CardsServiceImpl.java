package com.eazybytes.cards.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eazybytes.cards.constants.CardsConstants;
import com.eazybytes.cards.dto.CardDto;
import com.eazybytes.cards.entity.Cards;
import com.eazybytes.cards.exception.CardAlreadyExistsException;
import com.eazybytes.cards.exception.ResourceNotFoundException;
import com.eazybytes.cards.mapper.CardsMapper;
import com.eazybytes.cards.repository.CardsRepository;
import com.eazybytes.cards.service.ICardsService;

@Service
public class CardsServiceImpl implements ICardsService{
	
	@Autowired
	CardsRepository cardsRepository;

	public void createCard(String mobileNumber) {
		if(cardsRepository.findCardsByMobileNumber(mobileNumber).isPresent()) {
			throw new CardAlreadyExistsException("The Card given already exists");
		}
		Cards card = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        card.setCardNumber(Long.toString(randomCardNumber));
		card.setAmountUsed(0);
		card.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
		card.setCardType(CardsConstants.CREDIT_CARD);
		card.setMobileNumber(mobileNumber);
		card.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
		cardsRepository.save(card);
	}

	@Override
	public CardDto fetchCard(String mobileNumber) {
		Cards card = cardsRepository.findCardsByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Cards", "Mobile Number", mobileNumber));
		return CardsMapper.CardToCardDto(card);
	}

	@Override
	public CardDto updateCard(CardDto cardDto) {
		Cards card = cardsRepository.findCardsByCardNumber(cardDto.getCardNumber()).orElseThrow(() -> new ResourceNotFoundException("Cards", "Card Number", cardDto.getCardNumber()));
		CardsMapper.CardDtoToCard(cardDto, card);
		cardsRepository.save(card);
		return CardsMapper.CardToCardDto(card);
	}

	@Override
	public void deleteCard(String mobileNumber) {
		Cards card = cardsRepository.findCardsByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Cards", "Mobile Number", mobileNumber));
		cardsRepository.delete(card);
	}
}
