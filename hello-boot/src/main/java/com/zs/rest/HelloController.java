package com.zs.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/v1/api")
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello and Welcome to Spring Boot";
	}
	
	@GetMapping("/greet")
	public String greeting() {
		return "Happy Holidays!";
	}
}
