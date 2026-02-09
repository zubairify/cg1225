package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.CustomerDTO;
import com.zs.entity.Customer;
import com.zs.error.InvalidCustomerException;
import com.zs.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;
	
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
}
