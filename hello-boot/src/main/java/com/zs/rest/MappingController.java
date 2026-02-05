package com.zs.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/v1/mapping")
public class MappingController {

	@GetMapping
	public String getMapping() {
		return "Testing Get mapping";
	}
	
	@PostMapping
	public String postMapping() {
		return "Testing Post mapping";
	}
	
	@PutMapping
	public String putMapping() {
		return "Testing Put mapping";
	}
	
	@DeleteMapping
	public String delMapping() {
		return "Testing Delete mapping";
	}
}
