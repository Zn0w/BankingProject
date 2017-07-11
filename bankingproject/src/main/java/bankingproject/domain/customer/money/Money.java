package bankingproject.domain.customer.money;

public class Money {
	
	private int amount;
	private String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public void add(Money money) {
		if (currency.equals(money.getCurrency())) {
			amount += money.getAmount();
		}
		else {
			try {
				Double coefficient = CurrencyHandler.getCurrencyCoefficient(money.getCurrency(), currency);
				
				amount += money.getAmount() * coefficient;
			} catch (IllegalCurrencyException e) {
				e.printStackTrace();
				// Go to error page
			}
		}
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

	public int getAmount() {
		return amount;
	}
	
}
