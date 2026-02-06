package com.zs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.UserDTO;
import com.zs.entity.User;
import com.zs.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/add")
	public ResponseEntity<User> save(@RequestBody @Valid UserDTO dto) {
		User usr = service.save(dto);
		return new ResponseEntity<User>(usr, HttpStatus.OK);
	}
	
	@GetMapping("/{uid}")
	public ResponseEntity<User> find(@PathVariable int uid) {
		User usr = service.find(uid);
		return new ResponseEntity<User>(usr, HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> list() {
		List<User> users = service.list();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
