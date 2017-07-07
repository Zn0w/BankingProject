package bankingproject.dao.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bankingproject.dao.DaoException;
import bankingproject.dao.DaoFactory;
import bankingproject.domain.staff.Admin;

public class AdminDaoImpl implements AdminDao {

	private DaoFactory daoFactory = new DaoFactory();
	
	private final static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	
	@Override
	public List<Admin> getAdmins() throws DaoException {
		logger.info("Getting admins");
		
		List<Admin> admins = new ArrayList<Admin>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from admins");
			
			while (rs.next()) {
				Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				admins.add(admin);
			}
			
			logger.info("Got admins");
		} catch (SQLException e) {
			logger.error("Failed to get admins", e);
			throw new DaoException("Failed to get admins", e);
		} finally {
			daoFactory.close(rs);
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
		
		return admins;
	}

	@Override
	public Admin getAdmin(String login) throws DaoException {
		logger.info("Getting admin with login " + login);
		
		Admin admin = null;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from admins where login = '" + login + "'");
			
			if (rs.next()) {
				admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				logger.info("Got admin with login " + login);
			}
			else {
				logger.info("Admin with login " + login + " doesn't exist");
			}
		} catch (SQLException e) {
			logger.error("Failed to get admin with login " + login, e);
			throw new DaoException("Failed to get admin with login " + login, e);
		} finally {
			daoFactory.close(rs);
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
		
		return admin;
	}

	@Override
	public void createAdmin(String name, String login, String password, String confirmationPassword) throws DaoException {
		logger.info("Creating admin with login" + login);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("insert into admins(name, login, password, confirmation_password) values('" + name + "', '" + login + "', '" + password + "', '" + confirmationPassword + "')");
			
			logger.info("Admin with login " + login + " has been created");
		} catch (SQLException e) {
			logger.error("Failed to create admin with login " + login, e);
			throw new DaoException("Failed to create admin with login " + login, e);
		} finally {
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}

	@Override
	public void deleteAdmin(String login) throws DaoException {
		logger.info("Deleting admin with login " + login);
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("delete from admins where login = '" + login + "'");
			
			logger.info("Admin with login " + login + " has been deleted");
		} catch (SQLException e) {
			logger.error("Failed to delete admin with login " + login, e);
			throw new DaoException("Failed to delete admin with login " + login, e);
		} finally {
			daoFactory.close(statement);
			daoFactory.close(connection);
		}
	}
	
}
