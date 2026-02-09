package com.zs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zs.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p ORDER BY price")
	List<Product> findByPriceLowToHigh();
	
	List<Product> findByPriceBetween(double min, double max);
}
