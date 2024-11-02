package com.eazybytes.cards.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "cards")
@Setter
@Getter
public class CardsContactInfoDto {
	
	private String message;
	private Map<String,String> contactDetails;
	private List<String> onCallSupport;
}
