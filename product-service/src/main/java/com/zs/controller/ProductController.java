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

import com.zs.dto.ProductDTO;
import com.zs.entity.Product;
import com.zs.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody @Valid ProductDTO dto) {
		Product p = service.save(dto);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Product> find(@PathVariable int code) {
		Product p = service.find(code);
		return new ResponseEntity<Product>(p, HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> list() {
		List<Product> list = service.list();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/low2high")
	public ResponseEntity<List<Product>> priceLowToHight() {
		List<Product> list = service.priceLowToHigh();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/price")
	public ResponseEntity<List<Product>> priceRange(@RequestParam double min, @RequestParam double max) {
		List<Product> list = service.byPriceRange(min, max);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
}
