package com.zs.service;

import java.time.LocalDate;
import java.util.List;

import com.zs.dto.OrderDTO;
import com.zs.dto.StatusDTO;
import com.zs.entity.Order;

public interface OrderService {
	
	Order placeOrder(OrderDTO dto);
	Order find(int ordNo);
	List<Order> list();
	List<Order> listByCust(int custId);
	List<Order> listByStatus(String status);
	List<Order> listByOrderDate(LocalDate start, LocalDate end);
	Order updateOrder(StatusDTO dto);
}
