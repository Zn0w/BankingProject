package bankingproject.dao.transaction;

import java.util.List;

import bankingproject.dao.DaoException;
import bankingproject.domain.customer.transaction.Transaction;

public interface TransactionDao {
	
	public void saveTransaction(int customerId, String info) throws DaoException;
	
	public List<Transaction> getTransactions() throws DaoException;
	
	public List<Transaction> getTransactions(int customerId) throws DaoException;
	
}
