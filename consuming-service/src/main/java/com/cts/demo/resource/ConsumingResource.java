package com.cts.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumingResource {

	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/messages")
	public String getMessage() {
		
		
		String firstMessage=restTemplate.getForObject("http://first-service/first", String.class);
		String secondMessage = restTemplate.getForObject("http://second-service/second", String.class);
		
		return firstMessage+" ---- "+secondMessage;
	}
}
