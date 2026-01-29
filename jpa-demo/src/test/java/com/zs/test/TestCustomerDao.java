package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.CustomerDao;
import com.zs.entity.Customer;

public class TestCustomerDao {
	private static CustomerDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new CustomerDao();
	}
	
	@Test
	public void testSave() {
		Customer c = new Customer(103, "Edie", "3123123123");
		assertTrue(dao.save(c));
	}
	
	@Test
	public void testFind() {
		Customer c = dao.find(101);
		assertNotNull(c);
		System.out.println(c);
	}
	
	@Test
	public void testDelete() {
		assertTrue(dao.delete(101));
	}
	
	@Test
	public void testList() {
		List<Customer> customers = dao.list();
		assertTrue(customers.size() > 0);
		customers.forEach(System.out::println);
	}
	
	@Test
	public void testStartWithE() {
		List<Customer> customers = dao.startWithE();
		assertFalse(customers.isEmpty());
		customers.forEach(System.out::println);
	}
}

