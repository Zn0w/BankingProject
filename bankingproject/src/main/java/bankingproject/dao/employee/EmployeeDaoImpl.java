package bankingproject.dao.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bankingproject.dao.DaoException;
import bankingproject.dao.DaoFactory;
import bankingproject.domain.staff.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private DaoFactory daoFactory = new DaoFactory();
	
	private final static Logger logger = Logger.getLogger(EmployeeDao.class);

	@Override
	public List<Employee> getEmployees() throws DaoException {
		logger.info("Getting all employees");
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		logger.trace("Setting up connection");
		connection = daoFactory.getConnection();
		
		try {
			logger.trace("Creating statement");
			statement = connection.createStatement();
			
			logger.trace("Getting result set");
			rs = statement.executeQuery("select * from employees");
			
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				employees.add(employee);
			}
			
			logger.info("Got employees");
		} catch (SQLException e) {
			logger.error("Failed to get employyes");
			throw new DaoException("Failed to get employees", e);
		} finally {
			logger.trace("Closing result set");
			daoFactory.close(rs);
			
			logger.trace("Closing statement");
			daoFactory.close(statement);
			
			logger.trace("Closing connection");
			daoFactory.close(connection);
		}
		
		return employees;
	}

	@Override
	public Employee getEmployee(String login) throws DaoException {
		logger.info("Getting employee with login: " + login);
		
		Employee employee = null;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		logger.trace("Setting up connection");
		connection = daoFactory.getConnection();
		
		try {
			logger.trace("Creating statement");
			statement = connection.createStatement();
			
			logger.trace("Getting result set");
			rs = statement.executeQuery("select * from employees where login = '" + login + "'");
			
			rs.next();
			
			employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			logger.info("Got employee with login: " + login);
		} catch (SQLException e) {
			logger.error("Failed to get employee with login: " + login, e);
			throw new DaoException("Failed to get employee with login: " + login, e);
		} finally {
			logger.trace("Closing result set");
			daoFactory.close(rs);
			
			logger.trace("Closing statement");
			daoFactory.close(statement);
			
			logger.trace("Closing connection");
			daoFactory.close(connection);
		}
		
		return employee;
	}

	@Override
	public void createNewEmployee(String name, String login, String password) throws DaoException {
		logger.info("Creating new employee with login: " + login);
		
		Connection connection = null;
		Statement statement = null;
		
		logger.trace("Setting up connection");
		connection = daoFactory.getConnection();
		
		try {
			logger.trace("Creating statement");
			statement = connection.createStatement();
			
			logger.trace("Executing update statement");
			statement.executeUpdate("insert into employees(name, login, password) values('" + name + "', '" + login + "', '" + password + "')");
			
			logger.info("Employee with login: " + login + " has been created");
		} catch (SQLException e) {
			logger.error("Failed to get employee with login: " + login, e);
			throw new DaoException("Failed to get employee with login: " + login, e);
		} finally {
			logger.trace("Closing statement");
			daoFactory.close(statement);
			
			logger.trace("Closing connection");
			daoFactory.close(connection);
		}
	}

	@Override
	public void deleteEmployee(String login) throws DaoException {
		logger.info("Deleting employee with login: " + login);
		
		Connection connection = null;
		Statement statement = null;
		
		logger.trace("Setting up connection");
		connection = daoFactory.getConnection();
		
		try {
			logger.trace("Creating statement");
			statement = connection.createStatement();
			
			logger.trace("Executing update");
			statement.executeUpdate("delete from employees where login = '" + login + "'");
			
			logger.info("Employee with login: " + login + " has been deleted");
		} catch (SQLException e) {
			logger.error("Failed to delete employee with login: " + login, e);
			throw new DaoException("Failed to delete employee with login: " + login, e);
		} finally {
			logger.trace("Closing statement");
			daoFactory.close(statement);
			
			logger.trace("Closing connection");
			daoFactory.close(connection);
		}
	}
	
}
