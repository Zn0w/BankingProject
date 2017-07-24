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
			rs = statement.executeQuery("select * from customers where id = '"+id+"'");
			
			if (rs.next()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getInt(3));
				logger.info("Got customer with id " + id);
			}
			else {
				logger.info("Customer with id " + id + " doesn't exist");
			}
			return customer;
		} catch (SQLException e) {
			logger.error("Failed to get customer with id " + id, e);
			throw new DaoException("Failed to get customer with id " + id, e);
		} finally {
			daoFactory.close(rs);
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}

	@Override
	public void createCustomer(String name, int age) throws DaoException {
		logger.info("Creating new customer " + name + " " + age);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("insert into customers(name, age) values('"+name+"', '"+age+"')");
			
			logger.info("Customer " + name + " " + age + " has been created");
		} catch (SQLException e) {
			logger.error("Failed to create customer", e);
			throw new DaoException("Failed to create customer", e);
		} finally {
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}

	@Override
	public void deleteCustomer(int id) throws DaoException {
		logger.info("Deleting customer " + id);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("delete from customers where id = '"+id+"'");
			
			logger.info("Customer " + id + " has been deleted");
		} catch (SQLException e) {
			logger.error("Failed to delete customer", e);
			throw new DaoException("Failed to delete customer", e);
		} finally {
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}

	@Override
	public Customer getCustomer(String name, int age) throws DaoException {
		logger.info("Getting customer " + name + " age: " + age);
		
		Customer customer = null;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from customers where name = '"+name+"' and age = '"+age+"'");
			
			
			if (rs.next()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getInt(3));
				logger.info("Got customer " + name + " age: " + age);
			}
			else {
				logger.info("Customer " + name + " age: " + age);
			}
			return customer;
		} catch (SQLException e) {
			logger.error("Failed to get customer " + name + " age: " + age, e);
			throw new DaoException("Failed to get customer " + name + " age: " + age, e);
		} finally {
			daoFactory.close(rs);
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}
	
}
