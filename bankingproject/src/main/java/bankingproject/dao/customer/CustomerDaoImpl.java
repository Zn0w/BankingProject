package bankingproject.dao.customer;

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

public class CustomerDaoImpl implements CustomerDao {
	
	private DaoFactory daoFactory = new DaoFactory();
	
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	@Override
	public List<Customer> getCustomers() throws DaoException {
		logger.info("Getting customers");
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from customers");
			
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getInt(3));
				customers.add(customer);
			}
			
			logger.info("Got customers");
		} catch (SQLException e) {
			logger.error("Failed to get customers", e);
			throw new DaoException("Failed to get customers", e);
		} finally {
			daoFactory.close(rs);
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
		
		return customers;
	}

	@Override
	public Customer getCustomer(int id) throws DaoException {
		logger.info("Getting customer with id " + id);
		
		Customer customer = null;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.getResultSet();
			
			if (rs.next()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getInt(3));
				logger.info("Got customer with id " + id);
			}
			else {
				logger.info("Customer with id " + id + " doesn't exist");
			}
		} catch (SQLException e) {
			logger.error("Failed to get customer with id " + id, e);
			throw new DaoException("Failed to get customer with id " + id, e);
		} finally {
			daoFactory.close(rs);
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
		
		return customer;
	}

	@Override
	public void createCustomer(String name, int age) throws DaoException {
		
	}

	@Override
	public void deleteCustomer(int id) throws DaoException {
		
	}
	
}
