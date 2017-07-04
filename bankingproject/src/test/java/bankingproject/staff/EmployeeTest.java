package bankingproject.staff;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bankingproject.domain.NameContainer;
import bankingproject.domain.staff.Employee;

public class EmployeeTest {
	
	@Test
	public void checkInit() {
		int id = 1;
		String name = "Mark Ower";
		String login = "emlp";
		String password = "12345";
		
		Employee employee = new Employee(id, new NameContainer(name), login, password);
		
		assertEquals(id, employee.getId());
		assertEquals(name, employee.getName().getFullName());
		assertEquals(login, employee.getLogin());
		assertEquals(password, employee.getPassword());
	}
	
}
