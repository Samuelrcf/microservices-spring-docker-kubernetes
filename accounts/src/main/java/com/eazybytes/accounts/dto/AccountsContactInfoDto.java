package com.eazybytes.accounts.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ConfigurationProperties(prefix = "accounts")
public class AccountsContactInfoDto {
	
	private String message;
	private Map<String,String> contactDetails;
	private List<String> onCallSupport;
	
}
