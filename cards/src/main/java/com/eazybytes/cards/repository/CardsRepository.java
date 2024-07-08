package com.eazybytes.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.cards.entity.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long>{

	Optional<Cards> findCardsByMobileNumber(String mobileNumber);
	Optional<Cards> findCardsByCardNumber(String cardNumber);
}
