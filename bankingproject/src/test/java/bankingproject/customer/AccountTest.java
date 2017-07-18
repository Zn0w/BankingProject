package bankingproject.customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bankingproject.domain.customer.Account;
import bankingproject.domain.customer.money.Money;

public class AccountTest {
	
	@Test
	public void checkTransaction() {
		Account aFrom = new Account(102, new Money(500, "USD"));
		Account aTo = new Account(134, new Money(20, "USD"));
		
		aFrom.transfer(aTo, new Money(100, "USD"));
		
		assertEquals(400, aFrom.getBalance().getAmount(), 0.01);
		assertEquals(120, aTo.getBalance().getAmount(), 0.01);
	}
	
}
