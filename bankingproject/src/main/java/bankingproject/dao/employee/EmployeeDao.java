package bankingproject.dao.employee;

import java.util.List;

import bankingproject.dao.DaoException;
import bankingproject.domain.staff.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees() throws DaoException;
	
	public Employee getEmployee(String login) throws DaoException;
	
	public void createNewEmployee(String name, String login, String password) throws DaoException;
	
	public void deleteEmployee(String login) throws DaoException;
	
}
