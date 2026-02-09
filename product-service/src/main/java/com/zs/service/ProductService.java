package com.zs.service;

import java.util.List;

import com.zs.dto.ProductDTO;
import com.zs.entity.Product;

public interface ProductService {

	Product save(ProductDTO dto);
	
	Product find(int code);
	
	List<Product> list();
	
	List<Product> priceLowToHigh();
	
	List<Product> byPriceRange(double min, double max);
	
	static Product transform(ProductDTO dto) {
		Product p = new Product();
		p.setCode(dto.getCode());
		p.setProdName(dto.getProdName());
		p.setPrice(dto.getPrice());
		return p;
	}
}
