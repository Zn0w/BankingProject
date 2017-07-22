package bankingproject.dao.customer;

import java.util.List;

import bankingproject.dao.DaoException;
import bankingproject.domain.customer.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers() throws DaoException;
	
	public Customer getCustomer(int id) throws DaoException;
	
	public void createCustomer(String name, int age) throws DaoException;
	
	public void deleteCustomer(int id) throws DaoException;
	
	public Customer getCustomer(String name, int age) throws DaoException;
	
}
