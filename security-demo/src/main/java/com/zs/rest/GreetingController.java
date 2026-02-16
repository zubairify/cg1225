package com.zs.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello user!";
	}
	
	@GetMapping("/hola")
	public String sayHola() {
		return "Hola user!";
	}
}
