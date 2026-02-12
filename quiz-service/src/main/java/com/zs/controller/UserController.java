package com.zs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.LoginDTO;
import com.zs.dto.UserDTO;
import com.zs.entity.User;
import com.zs.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController @RequestMapping("/api/v1/users") 
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody @Valid UserDTO dto) {
		log.info("Request received to save user");
		User usr = service.save(dto);
		return new ResponseEntity<User>(usr, HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<User> login(@RequestBody @Valid LoginDTO dto) {
		log.info("Request received to validate user login");
		User usr = service.login(dto);
		return new ResponseEntity<User>(usr, HttpStatus.FOUND);
	}
}
