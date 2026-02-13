package com.zs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.TestDTO;
import com.zs.entity.Result;
import com.zs.service.TestService;

@RestController
@RequestMapping("/api/v1/tests")
public class TestController {

	@Autowired
	private TestService service;
	
	@PostMapping("/submit")
	public ResponseEntity<Result> submit(@RequestBody TestDTO dto) {
		Result rs = service.submit(dto);
		return new ResponseEntity<Result>(rs, HttpStatus.OK);
	}
}
