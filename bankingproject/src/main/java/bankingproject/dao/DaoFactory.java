package bankingproject.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class DaoFactory {
	
	private Connection connection;
	
	private final String URL = "jdbc:mysql://localhost:3306/banking_project";
	private final String USERNAME = "";
	private final String PASSWORD = "";
	
	private final static Logger logger = Logger.getLogger(DaoFactory.class);
	
	public void establishConnection() throws DaoException {
		logger.info("Establishing db connection");
		
		try {
			Driver driver = new FabricMySQLDriver();
			DriverManager.registerDriver(driver);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			logger.error("Failed to establish connection", e);
			throw new DaoException("Failed to establish connection", e);
		}
		
		logger.info("Connection has been established");
	}
	
	public Connection getConnection() {
		return connection;
	}
	
}
