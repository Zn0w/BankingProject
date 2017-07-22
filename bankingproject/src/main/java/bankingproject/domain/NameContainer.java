package bankingproject.domain;

import org.apache.log4j.Logger;

public class NameContainer {
	
	private String firstName = "";
	private String lastName = "";
	
	private final static Logger logger = Logger.getLogger(NameContainer.class);
	
	public NameContainer(String fullName) {
		logger.info("Passing name " + fullName);
		
		String[] nameComponents = fullName.split(" ");
		
		if (nameComponents.length != 2) {
			logger.error("Full name has been passed in incorrect format.");
		}
		else {
			firstName = nameComponents[0];
			lastName = nameComponents[1];
		}
	}
	
	public NameContainer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
}
