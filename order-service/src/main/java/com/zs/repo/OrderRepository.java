package com.zs.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByStatus(String status);
	
	List<Order> findByOrdDateBetween(LocalDate start, LocalDate end);
	
	List<Order> findByCustIdOrderByOrdDate(int custId);
}
