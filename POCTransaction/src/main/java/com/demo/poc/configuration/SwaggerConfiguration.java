package com.demo.poc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final Contact DEFAULT_CONTACT=new Contact("Mitesh Upadhyay","TestURL@techmahindra.com", "MU00575607@techmahindra.com");
	
	@SuppressWarnings("deprecation")
	public static final ApiInfo DEFAULT_API_INFO=new ApiInfo("1V4C","Mitesh API Descriprion","1.0", "termsOfServiceUrl","DEFAULT_CONTACT", "license", "licenseUrl");
	
	 @Bean
	    public Docket employeeApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.transaction.demo"))
	                .paths(regex("/v2/masterCard.*"))
	                .build()
	                .apiInfo(DEFAULT_API_INFO);
	    }
}
