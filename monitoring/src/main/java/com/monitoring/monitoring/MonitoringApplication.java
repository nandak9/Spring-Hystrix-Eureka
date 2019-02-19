package com.monitoring.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableHystrixDashboard
@SpringBootApplication
@EnableDiscoveryClient
public class MonitoringApplication extends SpringBootServletInitializer{

	@RequestMapping("/")
	public String homePage() {
		return "forward:/hystrix";

	}
	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MonitoringApplication.class).web(true);
	}
}
