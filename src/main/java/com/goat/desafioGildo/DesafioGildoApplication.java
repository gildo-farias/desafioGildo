package com.goat.desafioGildo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/** @author GILDO */

@SpringBootApplication
public class DesafioGildoApplication {
	
	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl("http://www.omdbapi.com").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DesafioGildoApplication.class, args);		
	}

}
