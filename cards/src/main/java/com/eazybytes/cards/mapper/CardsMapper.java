package com.eazybytes.cards.mapper;

import com.eazybytes.cards.dto.CardDto;
import com.eazybytes.cards.entity.Cards;

public class CardsMapper {

	public static CardDto CardToCardDto(Cards card) {
		CardDto cardDto = new CardDto();
		cardDto.setAmountUsed(card.getAmountUsed());
		cardDto.setAvailableAmount(card.getAvailableAmount());
		cardDto.setCardType(card.getCardType());
		cardDto.setMobileNumber(card.getMobileNumber());
		cardDto.setTotalLimit(card.getTotalLimit());
		return cardDto;
	}
	
	public static Cards CardDtoToCard(CardDto cardDto) {
		Cards card = new Cards();
		card.setAmountUsed(cardDto.getAmountUsed());
		card.setAvailableAmount(cardDto.getAvailableAmount());
		card.setCardNumber(cardDto.getCardNumber());
		card.setCardType(cardDto.getCardType());
		card.setMobileNumber(cardDto.getMobileNumber());
		card.setTotalLimit(cardDto.getTotalLimit());
		return card;
	}
	
}
