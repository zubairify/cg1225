package com.zs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.LoginDTO;
import com.zs.service.LoginService;

import jakarta.validation.Valid;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService service;

	@PostMapping(value = "/login", consumes = "application/json")
	public String validate(@RequestBody @Valid LoginDTO login) {
		if(service.authenticate(login))
			return "Login Successful";
		else
			return "Login Failed";
	}
}
