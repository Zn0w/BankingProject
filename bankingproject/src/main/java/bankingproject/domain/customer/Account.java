package bankingproject.domain.customer;

import bankingproject.domain.customer.money.Money;

public class Account {
	
	private int id;
	private Money balance;
	
	public Account(int id, Money balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public void transfer(Account account, Money amount) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}
	
}
