package bankingproject.customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bankingproject.domain.customer.money.Money;

public class MoneyTest {
	
	@Test
	public void checkAdditionSameCurrency() {
		String result = "15.0";
		
		Money money1 = new Money(10, "USD");
		Money money2 = new Money(5, "USD");
		
		money1.add(money2);
		
		assertEquals(String.valueOf(money1.getAmount()), result);
	}
	
	@Test
	public void checkAdditionDifferentCurrency() {
		Money m1 = new Money(5, "USD");
		Money m2 = new Money(120, "RUB");
		
		m1.add(m2);
		System.out.println("m1: " + m1.getAmount() + " " + m1.getCurrency());
		
		m2.add(m1);
		System.out.println("m2: " + m2.getAmount() + " " + m2.getCurrency());
	}
	
	@Test
	public void check() {
		System.out.println(Math.round(0.01623428));
	}
	
}
