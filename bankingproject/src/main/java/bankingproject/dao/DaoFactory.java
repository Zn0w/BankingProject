package bankingproject.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class DaoFactory {
	
	private final String URL = "jdbc:mysql://localhost:3306/banking_project";
	private final String USERNAME = "";
	private final String PASSWORD = "";
	
	private final static Logger logger = Logger.getLogger(DaoFactory.class);
	
	public Connection getConnection() {
		logger.info("Establishing db connection");
		
		try {
			Driver driver = new FabricMySQLDriver();
			DriverManager.registerDriver(driver);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			logger.info("Connection has been established");
			
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			logger.error("Failed to establish connection", e);
		}
		return null;
	}
	
	public void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				
				logger.trace("Connection has been closed");
			} catch (SQLException e) {
				logger.warn("Failed to close connection");
			}
		}
		else {
			logger.debug("Connection is null");
		}
	}
	
	public void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
				
				logger.trace("Statement has been closed");
			} catch (SQLException e) {
				logger.warn("Failed to close statement");
			}
		} 
		else {
			logger.debug("Statement is null");
		}
	}
	
	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				
				logger.trace("Result set has been closed");
			} catch (SQLException e) {
				logger.warn("Failed to close result set");
			}
		}
		else {
			logger.debug("Result set is null");
		}
	}
	
}
