package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.OrderedProduct;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {

}
