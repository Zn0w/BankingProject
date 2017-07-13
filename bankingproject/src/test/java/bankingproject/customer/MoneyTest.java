package bankingproject.customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bankingproject.domain.customer.money.Money;

public class MoneyTest {
	
	@Test
	public void checkAdditionSameCurrency() {
		double result = 15;
		
		Money money1 = new Money(10, "USD");
		Money money2 = new Money(5, "USD");
		
		money1.add(money2);
		
		assertEquals(money1.getAmount(), result, 0.01);
	}
	
	@Test
	public void checkAdditionDifferentCurrency() {
		Money m1 = new Money(5, "USD");
		Money m2 = new Money(120, "RUB");
		
		m1.add(new Money(120, "RUB"));
		System.out.println("m1: " + m1.getAmount() + " " + m1.getCurrency());
		assertEquals(6.92, m1.getAmount(), 0.01);
		
		m2.add(new Money(2, "USD"));
		System.out.println("m2: " + m2.getAmount() + " " + m2.getCurrency());
		assertEquals(241.6, m2.getAmount(), 0.01);
	}
	
	@Test
	public void checkSubtractionSameCurrency() {
		Money m1 = new Money(10, "USD");
		Money m2 = new Money(10, "USD");
		
		m1.subtract(new Money(5, "USD"));
		assertEquals(10 - 5, m1.getAmount(), 0.01);
		
		m2.subtract(new Money(4.45, "USD"));
		assertEquals(5.55, m2.getAmount(), 0.01);
	}
	
	@Test
	public void checkSubtractionDifferentCurrency() {
		Money m1 = new Money(10, "USD");
		Money m2 = new Money(5, "USD");
		
		m1.subtract(new Money(120, "RUB"));
		assertEquals(8.08, m1.getAmount(), 0.01);
		
		m2.subtract(new Money(3, "GBP"));
		assertEquals(1.154, m2.getAmount(), 0.01);
	}
	
}
