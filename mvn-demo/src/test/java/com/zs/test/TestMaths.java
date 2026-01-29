package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.math.Maths;

public class TestMaths {
	
	private static Maths m;
	
	@BeforeAll
	public static void init() {
		m = new Maths();
	}
	
	@Test
	public void testAdd() {
		assertEquals(10, m.add(4, 6));
	}
	
	@Test
	public void testDiv() {
		assertEquals(2, m.div(4, 2));
	}
	
	@Test
	public void testZeroDiv() {
		assertThrows(ArithmeticException.class, () -> m.div(3, 0));
	}
}

