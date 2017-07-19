package bankingproject.dao.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bankingproject.dao.DaoException;
import bankingproject.dao.DaoFactory;
import bankingproject.domain.customer.Account;
import bankingproject.domain.customer.money.Money;

public class AccountDaoImpl implements AccountDao {
	
	private DaoFactory daoFactory = new DaoFactory();
	
	private final static Logger logger = Logger.getLogger(AccountDaoImpl.class);

	@Override
	public List<Account> getCustomerAccounts(int customerId) throws DaoException {
		logger.info("Getting accounts of customer " + customerId);
		
		List<Account> accounts = new ArrayList<Account>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from accounts where customer = '"+customerId+"'");
			
			while (rs.next()) {
				Account account = new Account(rs.getInt(1), new Money(rs.getDouble(2), rs.getString(3)));
				accounts.add(account);
			}
			
			logger.trace("Got accounts of customer " + customerId);
		} catch (SQLException e) {
			logger.error("Failed to get accounts of customer " + customerId, e);
			throw new DaoException("Failed to get accounts of customer " + customerId, e);
		} finally {
			daoFactory.close(rs);
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
		
		return accounts;
	}

	@Override
	public void createAccount(int customerId, String currency) throws DaoException {
		logger.info("Creating account for customer " + customerId);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate("insert into accounts(balance, currency, customer) values('"+0+"', '"+currency+"', '"+customerId+"')");
			
			logger.trace("Account for customer " + customerId + " has been created");
		} catch (SQLException e) {
			logger.error("Failed to create account for customer " + customerId, e);
			throw new DaoException("Failed to create account for customer " + customerId, e);
		} finally {
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}

	@Override
	public void deleteAccount(int id) throws DaoException {
		logger.info("Deleting account " + id);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate("delete from accounts where id = '"+id+"'");
			
			logger.trace("Account " + id + " has been deleted");
		} catch (SQLException e) {
			logger.error("Failed to delete account " + id, e);
			throw new DaoException("Failed to delete account " + id, e);
		} finally {
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}
	
}
