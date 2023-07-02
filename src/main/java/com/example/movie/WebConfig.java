package com.example.movie;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Configuration for content negotiation

@Configuration
public class WebConfig implements WebMvcConfigurer{

	
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

	    //set path extension to true
	    configurer.favorPathExtension(true)
	    .favorParameter(true)
        .parameterName("mediaType")
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("xml", MediaType.APPLICATION_XML)
        .mediaType("json", MediaType.APPLICATION_JSON);
	  }
	
}
