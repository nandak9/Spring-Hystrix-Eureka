package com.naga.cloud.firstserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
//@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class FirstServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstServerApplication.class, args);
	}
}
