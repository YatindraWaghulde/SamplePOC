package com.transaction.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.transaction.demo.model.TransactionDetails;

@SpringBootApplication
public class OneViewForTransactionConsumerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OneViewForTransactionConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OneViewForTransactionConsumerApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			TransactionDetails quote = restTemplate.getForObject(
					"http://localhost:2030/v2/masterCard/transaction/1", TransactionDetails.class);
			log.info(quote.toString());
		};
	}
	
	
	
	
	
}
