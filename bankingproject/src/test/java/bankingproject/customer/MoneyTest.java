package bankingproject.customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bankingproject.domain.customer.money.Money;

public class MoneyTest {
	
	@Test
	public void checkAdditionSameCurrency() {
		int result = 15;
		
		Money money1 = new Money(10, "USD");
		Money money2 = new Money(5, "USD");
		
		money1.add(money2);
		
		assertEquals(money1.getAmount(), result);
	}
	
}
