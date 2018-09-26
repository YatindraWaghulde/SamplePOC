package com.demo.poc;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class POCConsumerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(POCConsumerApplication.class);

	private static File file;
	static
	{
		try {
			file = new ClassPathResource("Client.jks").getFile();
			String ster = file.getPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("javax.net.debug", "all");
		System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
		System.setProperty("https.protocols", "TLSv1.2");
		System.setProperty("javax.net.ssl.trustStore", file.getPath());
		System.setProperty("javax.net.ssl.trustStorePassword", "s3cr3t");
		System.setProperty("javax.net.ssl.keyStore",  file.getPath());
		System.setProperty("javax.net.ssl.keyStorePassword", "s3cr3t");
		
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				new javax.net.ssl.HostnameVerifier() {

					public boolean verify(String hostname,
							javax.net.ssl.SSLSession sslSession) {
						if (hostname.equals("localhost")) {
							return true;
						}
						return false;
					}
				});
	}

	@Bean
	public RestTemplate template() throws Exception{
		RestTemplate template = new RestTemplate();
		return template;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(POCConsumerApplication.class, args);
	}
	
	
	
	
	
	
	
	

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			TransactionDetails quote = restTemplate.getForObject(
//					"http://localhost:2030/v2/masterCard/transaction/1", TransactionDetails.class);
//			log.info(quote.toString());
//		};
//	}
	
	
	
	
	
}
