package com.zs.service;

import java.util.List;

import com.zs.dto.CustomerDTO;
import com.zs.entity.Customer;
import com.zs.vo.OrderVO;

public interface CustomerService {
	
	Customer save(CustomerDTO c);
	
	Customer find(int cid);
	
	List<Customer> list();
	
	List<OrderVO> orderHistory(int cid);
	
	static Customer transform(CustomerDTO dto) {
		Customer c = new Customer();
		c.setCustId(dto.getCustId());
		c.setCustName(dto.getCustName());
		c.setEmail(dto.getEmail());
		c.setMobile(dto.getMobile());
		return c;
	}
}
