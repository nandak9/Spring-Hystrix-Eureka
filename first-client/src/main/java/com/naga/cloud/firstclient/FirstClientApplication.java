package com.naga.cloud.firstclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class FirstClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstClientApplication.class, args);
	}
}

@Configuration
class Config
{
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}