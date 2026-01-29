package com.zs.bank;

public class Accounts {
	private double balance;
	
	public Accounts() {
		balance = 1000;
	}
	
	public double deposit(double amount) {
		if(amount < 0)
			throw new IllegalArgumentException("Negative amount");
		else
			balance += amount;
		return balance;
	}
	
	public double withdraw(double amount) throws BalanceException {
		if(amount < 0)
			throw new IllegalArgumentException("Negative amount");
		else if(amount > balance)
			throw new BalanceException("Insufficient balance");
		else
			balance -= amount;
		return balance;
	}
}
