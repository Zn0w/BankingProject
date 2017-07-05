package bankingproject.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bankingproject.dao.DaoException;
import bankingproject.dao.employee.EmployeeDao;
import bankingproject.dao.employee.EmployeeDaoImpl;
import bankingproject.domain.staff.Employee;

/**
 * Servlet implementation class EmployeeListServlet
 */
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(EmployeeListServlet.class);

    /**
     * Default constructor. 
     */
    public EmployeeListServlet() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		try {
			logger.info("Getting employees");
			List<Employee> employees = employeeDao.getEmployees();
			
			String employeeInfo[][] = new String[employees.size()][2];
			
			int i = 0;
			for (Employee employee : employees) {
				employeeInfo[i][0] = employee.getName().getFullName();
				employeeInfo[i][1] = employee.getLogin();
				
				i++;
			}
			
			request.setAttribute("employees", employeeInfo);
			
			request.getRequestDispatcher("employeeList.jsp").forward(request, response);
		} catch (DaoException e) {
			logger.error("Couldn't get employees");
			// Go to error page
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
