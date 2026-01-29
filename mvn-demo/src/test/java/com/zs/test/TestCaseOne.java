package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class TestCaseOne {

	@Test
	public void testAssertFunction() {
		String s1 = "Hello";
		String s2 = "Hell";
		
//		assertEquals(s1, s2);
//		assertSame(s1, s2);
//		assertNotSame(s1, s2);
		assertFalse(s1.equals(s2));
	}
}
