package com.eazybytes.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.eazybytes.accounts.dto.AccountsContactInfoDto;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients 
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info=@Info(
				title="Accounts microservice REST API Documentation",
				description="SRBank Accounts microservices REST API Documentation",
				version="v1",
				contact=@Contact(
						name="Samuel Rógenes",
						url="https://www.linkedin.com/in/samuel-r%C3%B3genes-69a25b238/")))
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
