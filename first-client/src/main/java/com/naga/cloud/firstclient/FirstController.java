package com.naga.cloud.firstclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


//@Service
@RestController
@RequestMapping("/rest/hello/client")
public class FirstController {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="failOver", groupKey="Hello",
			commandKey="hello",
			threadPoolKey="helloThread"
			)
	@GetMapping
	public String sayHello() {
		String url = "http://first-server/rest/hello/server";
		System.out.println("Client:: Say Hello");
		return restTemplate.getForObject(url, String.class);

	}
	
	public String failOver(Throwable e) {
		
		e.printStackTrace();
		
		 StackTraceElement stackTrace[] = e.getStackTrace();
		
		return "Fall back method triggered :: "+stackTrace[1].toString();
	}
}
