package com.zs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zs.dto.OrderDTO;
import com.zs.dto.StatusDTO;
import com.zs.entity.Order;
import com.zs.entity.OrderedProduct;
import com.zs.error.InvalidOrderException;
import com.zs.repo.OrderRepository;
import com.zs.vo.CustomerVO;
import com.zs.vo.ProductVO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private RestTemplate rest;

	@Override
	public Order placeOrder(OrderDTO dto) {
		String custServiceUrl = "http://localhost:8001/api/v1/customers/";
		String prodServiceUrl = "http://localhost:8002/api/v1/products/";

		Order order = new Order();

		CustomerVO custVo = rest.getForObject(custServiceUrl + dto.getCustId(), CustomerVO.class);
		if (custVo != null)
			order.setCustId(custVo.getCustId());

		List<OrderedProduct> products = new ArrayList<OrderedProduct>();
		for (int c : dto.getCodes()) {
			ProductVO prodVo = rest.getForObject(prodServiceUrl + c, ProductVO.class);
			if (prodVo != null) {
				OrderedProduct op = new OrderedProduct();
				op.setCode(prodVo.getCode());
				op.setOrder(order);
				products.add(op);
				order.setAmount(order.getAmount() + prodVo.getPrice());
			}
		}
		order.setProducts(products);
		
		return repo.save(order);
	}

	@Override
	public Order find(int ordNo) {
		return repo.findById(ordNo).orElseThrow(() -> new InvalidOrderException("Order not found with No: " + ordNo));
	}

	@Override
	public List<Order> list() {
		return repo.findAll();
	}

	@Override
	public List<Order> listByCust(int custId) {
		return repo.findByCustIdOrderByOrdDate(custId);
	}

	@Override
	public List<Order> listByStatus(String status) {
		return repo.findByStatus(status);
	}

	@Override
	public List<Order> listByOrderDate(LocalDate start, LocalDate end) {
		return repo.findByOrdDateBetween(start, end);
	}

	@Override
	public Order updateOrder(StatusDTO dto) {
		Order order = repo.findById(dto.getOrdNo()).get();
		if (dto.getStatus().equals("Delivered")) {
			order.setStatus(dto.getStatus());
			order.setDlvryDate(LocalDate.now());
		}
		return repo.save(order);
	}
}
