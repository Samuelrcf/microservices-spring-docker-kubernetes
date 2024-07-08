package com.eazybytes.cards.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void createCard(CardDto cardDto) {
		if(cardsRepository.findCardsByCardNumber(cardDto.getCardNumber()).isPresent()) {
			throw new CardAlreadyExistsException("Cards", "Card Number", cardDto.getCardNumber());
		}
		Cards card = CardsMapper.CardDtoToCard(cardDto);
		card.setCreatedAt(LocalDateTime.now());
		card.setCreatedBy("Anonymous");
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
		card.setAmountUsed(cardDto.getAmountUsed());
		card.setAvailableAmount(cardDto.getAvailableAmount());
		card.setCardType(cardDto.getCardType());
		card.setMobileNumber(cardDto.getMobileNumber());
		card.setTotalLimit(cardDto.getTotalLimit());
		card.setUpdateAt(LocalDateTime.now());
		card.setUpdateBy("Anonymous 2");
		cardsRepository.save(card);
		return CardsMapper.CardToCardDto(card);
		
	}

	@Override
	public void deleteCard(String mobileNumber) {
		Cards card = cardsRepository.findCardsByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Cards", "Mobile Number", mobileNumber));
		cardsRepository.delete(card);
	}
}
