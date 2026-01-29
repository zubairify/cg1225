package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestLifeCycle {

	private List<String> basket;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before all test cases");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("After all test cases");
	}
	
	@BeforeEach
	public void beforeEach() {
		basket = new ArrayList<String>();
		System.out.println("Before each test case");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("After each test case");
	}
	
	@Test
	public void testEmptyBasket() {
		System.out.println("Testing empty basket");
		assertTrue(basket.isEmpty());
	}
	
//	@Disabled
	@Test
	public void testOneItem() {
		System.out.println("Testing one item");
		basket.add("Orange");
		assertEquals(1, basket.size());
	}
}
