package bankingproject.domain.staff;

import bankingproject.domain.NameContainer;

public class Employee {
	
	protected int id;
	protected NameContainer name;
	protected String login = "";
	protected String password = "";
	
	public Employee(int id, String name, String login, String password) {
		this.id = id;
		this.name = new NameContainer(name);
		this.login = login;
		this.password = password;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
