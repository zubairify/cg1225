package com.zs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByOrderByPrice();
	
	List<Product> findByPriceBetween(double min, double max);
}
