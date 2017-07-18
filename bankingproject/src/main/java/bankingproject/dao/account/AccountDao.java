package bankingproject.dao.account;

import java.util.List;

import bankingproject.dao.DaoException;
import bankingproject.domain.customer.Account;

public interface AccountDao {
	
	public List<Account> getCustomerAccounts(int customerId) throws DaoException;
	
	public void createAccount(int customerId, String currency) throws DaoException;
	
	public void deleteAccount(int id) throws DaoException;
	
}
