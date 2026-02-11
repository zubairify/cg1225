package com.zs.cotroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.OrderDTO;
import com.zs.dto.StatusDTO;
import com.zs.entity.Order;
import com.zs.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/place")
	public ResponseEntity<Order> place(@RequestBody @Valid OrderDTO dto) {
		Order order = service.placeOrder(dto);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Order> update(@RequestBody @Valid StatusDTO dto) {
		Order order = service.updateOrder(dto);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@GetMapping("/{ordNo}")
	public ResponseEntity<Order> find(@PathVariable int ordNo) {
		Order order = service.find(ordNo);
		return new ResponseEntity<Order>(order, HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> list() {
		List<Order> list = service.list();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/customer/{custId}")
	public ResponseEntity<List<Order>> listByCustomer(@PathVariable int custId) {
		List<Order> list = service.listByCust(custId);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Order>> listByStatus(@PathVariable String status) {
		List<Order> list = service.listByStatus(status);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/dates")
	public ResponseEntity<List<Order>> listByOrderDates(@RequestParam LocalDate start,
			@RequestParam LocalDate end) {
		List<Order> list = service.listByOrderDate(start, end);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
}
