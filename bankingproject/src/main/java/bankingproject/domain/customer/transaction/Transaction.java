package bankingproject.domain.customer.transaction;

public class Transaction {
	
	private int accountId;
	private String info;
	
	public Transaction(int accountId, String info) {
		this.accountId = accountId;
		this.info = info;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
