package bankingproject.dao.transaction;

import java.util.List;

import bankingproject.dao.DaoException;
import bankingproject.domain.customer.transaction.Transaction;

public interface TransactionDao {
	
	public void saveSimpleTransaction() throws DaoException;
	
	public void saveTransferTransaction() throws DaoException;
	
	public List<Transaction> getTransactions() throws DaoException;
	
	public List<Transaction> getTransactions(int id) throws DaoException;
	
}
