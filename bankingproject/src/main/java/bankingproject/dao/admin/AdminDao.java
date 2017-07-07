package bankingproject.dao.admin;

import java.util.List;

import bankingproject.dao.DaoException;
import bankingproject.domain.staff.Admin;

public interface AdminDao {
	
	public List<Admin> getAdmins() throws DaoException;
	
	public Admin getAdmin(String login) throws DaoException;
	
	public void createAdmin(String name, String login, String password, String confirmationPassword) throws DaoException;
	
	public void deleteAdmin(String login) throws DaoException;
	
}
