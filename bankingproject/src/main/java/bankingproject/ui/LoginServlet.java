package bankingproject.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bankingproject.dao.DaoException;
import bankingproject.dao.employee.EmployeeDao;
import bankingproject.dao.employee.EmployeeDaoImpl;
import bankingproject.domain.staff.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = Logger.getLogger(LoginServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		try {
			logger.trace("Getting user with login " + login);
			Employee employee = employeeDao.getEmployee(login);
			
			if (employee == null) {
				request.setAttribute("message", "Login " + login + " does not exist");
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				Cookie cookie = new Cookie("login", login);
				response.addCookie(cookie);
				response.sendRedirect("employee/mainPage.jsp");
			}
		} catch (DaoException e) {
			logger.error("Failed to get user");
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
