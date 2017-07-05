package com.acadgild;

/**
 * 
 * Bank account class having withdraw and deposit methods.
 *
 */
class BankAccount {
	private int balance;

	public BankAccount(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	// withdraw method - deduct the amount from balance
	public void withdraw(int amount) {
		balance = balance - amount;
	}

	// deposit method - add the amount to balance
	public void deposit(int amount) {
		balance = balance + amount;
	}
}