package bankingproject.dao.employee;

import java.util.List;

import bankingproject.dao.DaoException;
import bankingproject.domain.staff.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees() throws DaoException;
	
	public Employee getEmployee(int id) throws DaoException;
	
	public void createNewEmployee() throws DaoException;
	
}
