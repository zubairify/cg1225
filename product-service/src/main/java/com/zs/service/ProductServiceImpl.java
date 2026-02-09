package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.ProductDTO;
import com.zs.entity.Product;
import com.zs.error.InvalidProductException;
import com.zs.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product save(ProductDTO dto) {
		return repo.save(ProductService.transform(dto));
	}

	@Override
	public Product find(int code) {
		return repo.findById(code).orElseThrow(
			() -> new InvalidProductException("Product not found with code: " + code));
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public List<Product> priceLowToHigh() {
		return repo.findByPriceLowToHigh();
	}

	@Override
	public List<Product> byPriceRange(double min, double max) {
		return repo.findByPriceBetween(min, max);
	}
}
