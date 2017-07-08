package bankingproject.domain.customer;

import java.util.ArrayList;
import java.util.List;

import bankingproject.domain.NameContainer;

public class Customer {
	
	private int id;
	private NameContainer name;
	private int age;
	private List<Account> accounts = new ArrayList<Account>();
	
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
