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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.FlightDTO;
import com.zs.entity.Flight;
import com.zs.service.FlightService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api/flights")
public class FlightController {

	@Autowired
	private FlightService service;
	
	@PostMapping(value = "/save", consumes = "application/json")
	public ResponseEntity<Flight> save(@RequestBody @Valid FlightDTO dto) {
		Flight f = service.save(dto);
		return new ResponseEntity<Flight>(f, HttpStatus.OK);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Flight> find(@PathVariable int code) {
		Flight f = service.find(code);
		return new ResponseEntity<Flight>(f, HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Flight>> list() {
		List<Flight> flights = service.list();
		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
	}
	
	@GetMapping("/carrier/{car}")
	public ResponseEntity<List<Flight>> findByCarrier(@PathVariable String car) {
		List<Flight> flights = service.findByCarrier(car);
		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
	}
	
	@GetMapping("/route")
	public ResponseEntity<List<Flight>> findByRoute(@RequestParam String src, @RequestParam String dest) {
		List<Flight> flights = service.findByRoute(src, dest);
		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
	}
}

