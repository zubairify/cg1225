package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zs.dto.CustomerDTO;
import com.zs.entity.Customer;
import com.zs.error.InvalidCustomerException;
import com.zs.repo.CustomerRepository;
import com.zs.vo.OrderVO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private RestTemplate rest;
	
	@Override
	public Customer save(CustomerDTO dto) {
		return repo.save(CustomerService.transform(dto));
	}

	@Override
	public Customer find(int cid) {
		return repo.findById(cid).orElseThrow(
			() -> new InvalidCustomerException("Customer not found with Id: " + cid));
	}

	@Override
	public List<Customer> list() {
		return repo.findAll();
	}

	@Override
	public List<OrderVO> orderHistory(int cid) {
		String orderUrl = "http://localhost:8003/api/v1/orders/customer/" + cid;
		
		List<OrderVO> orders = rest.getForObject(orderUrl, List.class);
		return orders;
	}
}
