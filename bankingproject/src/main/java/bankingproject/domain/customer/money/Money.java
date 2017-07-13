package bankingproject.domain.customer.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
	
	private double amount;
	private String currency;
	
	public Money(double amount, String currency) {
		this.amount = round(amount, 2);
		this.currency = currency;
	}
	
	public void add(Money money) {
		if (currency.equals(money.getCurrency())) {
			amount += money.getAmount();
		}
		else {
			try {
				Double coefficient = CurrencyHandler.getCurrencyCoefficient(money.getCurrency(), currency);
				
				amount += money.getAmount() * Money.round(coefficient, 3);
			} catch (IllegalCurrencyException e) {
				e.printStackTrace();
				// Go to error page
			}
		}
	}
	
	public void subtract(Money money) {
		if (currency.equals(money.getCurrency())) {
			amount -= money.getAmount();
		}
		else {
			try {
				Double coefficient = CurrencyHandler.getCurrencyCoefficient(money.getCurrency(), currency);
				
				amount -= money.getAmount() * Money.round(coefficient, 3);
			} catch (IllegalCurrencyException e) {
				e.printStackTrace();
				// Go to error page
			}
		}
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public void withdraw(Money money) {
		
	}
	
	public void changeCurrency(String newCurrency) {
		
	}
	
	public Money getInCurrency(String currency) {
		return null;
	}

	public String getCurrency() {
		return currency;
	}

	public double getAmount() {
		return round(amount, 2);
	}
	
}
