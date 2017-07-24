package bankingproject.domain.customer;

import org.apache.log4j.Logger;

import bankingproject.domain.customer.money.Money;

public class Account {
	
	private int id, ownerId;
	private Money balance;
	
	private final static Logger logger = Logger.getLogger(Account.class);
	
	public Account(int id, Money balance, int ownerId) {
		this.id = id;
		this.balance = balance;
		this.ownerId = ownerId;
	}
	
	public void transfer(Account account, Money amount) {
		logger.info("Transfer from " + id + " to " + account.id + " amount: " + amount.getAmount() + " " + amount.getCurrency());
		balance.subtract(amount);
		account.balance.add(amount);
		logger.trace("Transaction " + id + "-" + account.id + " : " + amount.getAmount() + " " + amount.getCurrency() + " has been completed");
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

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
}
