package bankingproject.domain.customer;

import java.util.List;

import bankingproject.dao.DaoException;
import bankingproject.dao.account.AccountDao;
import bankingproject.dao.account.AccountDaoImpl;
import bankingproject.domain.NameContainer;

public class Customer {
	
	private int id;
	private NameContainer name;
	private int age;
	private List<Account> accounts;
	
	public Customer(int id, String name, int age) {
		this.id = id;
		this.name = new NameContainer(name);
		this.age = age;
		
		AccountDao accountDao = new AccountDaoImpl();
		try {
			accounts = accountDao.getCustomerAccounts(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public NameContainer getName() {
		return name;
	}
	
	public void setName(NameContainer name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
