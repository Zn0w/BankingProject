package bankingproject.dao.transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bankingproject.dao.DaoException;
import bankingproject.dao.DaoFactory;
import bankingproject.domain.customer.Customer;
import bankingproject.domain.customer.transaction.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	private static final Logger logger = Logger.getLogger(TransactionDaoImpl.class);
	
	private DaoFactory daoFactory = new DaoFactory();
	
	@Override
	public void saveSimpleTransaction(int customerId, String info) throws DaoException {
		logger.info("Saving simple transaction " + customerId + ": " + info);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			
			statement.executeQuery("insert into transactions(customer_id, info) values('"+customerId+"', '"+info+"')");
			
			logger.info("Transaction has been saved");
		} catch (SQLException e) {
			logger.error("Failed to save transaction " + customerId + ": " + info, e);
			throw new DaoException("Failed to save transaction " + customerId + ": " + info, e);
		} finally {
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}

	@Override
	public void saveTransferTransaction() throws DaoException {
		
	}

	@Override
	public List<Transaction> getTransactions() throws DaoException {
		return null;
	}

	@Override
	public List<Transaction> getTransactions(int id) throws DaoException {
		return null;
	}
	
	
	
}