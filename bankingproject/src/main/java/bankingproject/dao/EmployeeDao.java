package bankingproject.dao;

import org.apache.log4j.Logger;

public class EmployeeDao {
	
	private DaoFactory daoFactory = new DaoFactory();
	
	private final static Logger logger = Logger.getLogger(EmployeeDao.class);
	
	public EmployeeDao() {
		try {
			daoFactory.establishConnection();
		} catch (DaoException e) {
			logger.error("Couldn't establish connection");
		}
	}
	
}
