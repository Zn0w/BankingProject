package bankingproject.domain.customer.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.log4j.Logger;

public class Money {
	
	private double amount;
	private String currency;
	
	private static final Logger logger = Logger.getLogger(Money.class);
	
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
	
	public void changeCurrency(String newCurrency) {
		logger.info("Changing currency from " + currency + " to " + newCurrency);
		
		if (currency.equals(newCurrency)) {
			logger.trace("Currency is same");
			return;
		} else {
			try {
				if ((currency.equals("USD")) || (!currency.equals("USD") && newCurrency.equals("USD"))) {
					Double coefficient = CurrencyHandler.getCurrencyCoefficient(currency, newCurrency);
					
					amount = round(amount, 2) * round(coefficient, 3);
					currency = newCurrency;
				} else if (!currency.equals("USD") && !newCurrency.equals("USD")) {
					Double coefficientUSD = CurrencyHandler.getCurrencyCoefficient(currency, "USD");
					
					amount = round(amount, 2) * round(coefficientUSD, 3);
					currency = "USD";
					System.out.println("1 amount: " + amount);
					
					Double coefficientCurrency = CurrencyHandler.getCurrencyCoefficient(currency, newCurrency);
					
					amount = round(amount, 2) * round(coefficientCurrency, 3);
					currency = newCurrency;
					System.out.println("2 amount: " + amount);
				}
			} catch (IllegalCurrencyException e) {
				e.printStackTrace();
				// Go to error page
			}
		}
	}

	public String getCurrency() {
		return currency;
	}

	public double getAmount() {
		return round(amount, 2);
	}
	
}
