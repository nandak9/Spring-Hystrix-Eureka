package com.naga.cloud.firstserver;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/hello/server")
@Service
public class FirstRestServerClass {
	
	@GetMapping
	public String hello() {

		System.out.println("Server: Hello");
		return "Hello world!!";
	}

}
