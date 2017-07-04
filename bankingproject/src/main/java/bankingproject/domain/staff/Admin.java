package bankingproject.domain.staff;

import bankingproject.domain.NameContainer;

public class Admin extends Employee {

	private String confirmationPassword = "";
	
	public Admin(int id, NameContainer name, String login, String password, String confirmationPassword) {
		super(id, name, login, password);
		this.confirmationPassword = confirmationPassword;
	}
	
}
