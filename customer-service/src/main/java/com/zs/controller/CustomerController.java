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

import com.zs.dto.CustomerDTO;
import com.zs.entity.Customer;
import com.zs.service.CustomerService;
import com.zs.vo.OrderVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> save(@RequestBody @Valid CustomerDTO dto) {
		Customer c = service.save(dto);
		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<Customer> find(@PathVariable int cid) {
		Customer c = service.find(cid);
		return new ResponseEntity<Customer>(c, HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> list() {
		List<Customer> list = service.list();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{custId}/orders")
	public ResponseEntity<List<OrderVO>> orderHistory(@PathVariable int custId) {
		List<OrderVO> orders = service.orderHistory(custId);
		return new ResponseEntity<List<OrderVO>>(orders, HttpStatus.OK);
	}
}
