package com.example.movie;

import java.util.concurrent.CompletableFuture;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompletableFutureService {

	  private final RestTemplate restTemplate;
	  
	  public CompletableFutureService(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}

	  @Async
	  public CompletableFuture<User> findUser(String user) throws InterruptedException {
	    log.info("Looking up " + user);
	    String url = String.format("https://api.github.com/users/%s", user);
	    User results = restTemplate.getForObject(url, User.class);
	    // Artificial delay of 1s for demonstration purposes
	    Thread.sleep(1000L);
	    return CompletableFuture.completedFuture(results);
	  }
}
