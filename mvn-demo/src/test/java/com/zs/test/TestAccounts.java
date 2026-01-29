package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zs.bank.Accounts;

public class TestAccounts {

	private Accounts acnt;
	
	@BeforeEach
	public void init() {
		acnt = new Accounts();
	}
	
	@Test
	public void testValidDeposit() {
		assertEquals(1500, acnt.deposit(500));
	}
	
	@Test
	public void testNegativeDeposit() {
		assertThrows(IllegalArgumentException.class, () -> acnt.deposit(-100));
	}
}
