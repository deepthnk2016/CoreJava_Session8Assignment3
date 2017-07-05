package com.acadgild;

/**
 * 
 * Main class to invoke the withdraw and deposit methods. Here, Deepak and Sweta
 * are withdrawing amounts parallely, so the makeWithdraw method is made
 * synchronized. So that, only one instance of makeWithdraw method will run at a
 * time.
 *
 */
public class Session8Assignment3 implements Runnable {
	private BankAccount acct = new BankAccount(50);

	public static void main(String[] args) {
		Session8Assignment3 bank = new Session8Assignment3();
		Thread first = new Thread(bank);
		Thread second = new Thread(bank);
		first.setName("Deepak");
		second.setName("Sweta");

		// Trigger both the threads.
		first.start();
		second.start();
	}

	@Override
	public void run() {
		// Perform withdraw 5 times
		for (int x = 0; x < 5; x++) {
			makeWithdrawal(10);
			if (acct.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}

	// Synchronized makeWithdrawal method. So that, only one withdraw can happen
	// at a time.
	private synchronized void makeWithdrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw " + 10);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " completes the withdraw");
			System.out.println("Balance = " + acct.getBalance());
		} else {
			System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + amt);
		}
		System.out.println("------------------------------------------------------");
	}

	// Synchronized makeDeposit method. So that, only one deposit can happen at
	// a time.
	public synchronized void makeDeposit(int amt) {
		System.out.println(Thread.currentThread().getName() + " is going to Deposit");
		try {
			Thread.sleep(100);

		} catch (InterruptedException ex) {
		}
		acct.deposit(20);
		System.out.println(Thread.currentThread().getName() + " completes the deposit");
	}
}