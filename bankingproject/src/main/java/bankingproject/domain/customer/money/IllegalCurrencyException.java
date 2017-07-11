package bankingproject.domain.customer.money;

public class IllegalCurrencyException extends Exception {
	
	public IllegalCurrencyException() {
		super();
	}
	
	public IllegalCurrencyException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalCurrencyException(String message) {
		super(message);
	}
	
}
