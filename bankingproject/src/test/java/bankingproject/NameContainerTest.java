package bankingproject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bankingproject.domain.NameContainer;

public class NameContainerTest {
	
	@Test
	public void checkInit() {
		String firstName = "Mark";
		String lastName = "Ower";
		String fullName = firstName + " " + lastName;
		
		NameContainer name = new NameContainer(fullName);
		
		assertEquals(name.getFirstName(), firstName);
		assertEquals(name.getLastName(), lastName);
		assertEquals(name.getFullName(), fullName);
	}
	
}
