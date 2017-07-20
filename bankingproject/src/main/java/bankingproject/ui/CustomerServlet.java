package bankingproject.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bankingproject.dao.DaoException;
import bankingproject.dao.customer.CustomerDao;
import bankingproject.dao.customer.CustomerDaoImpl;
import bankingproject.domain.customer.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(CustomerServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("query");
		
		CustomerDao customerDao = new CustomerDaoImpl();
		logger.trace("Get customer " + id);
		try {
			Customer customer = customerDao.getCustomer(Integer.parseInt(id));
			
			String name = customer.getName().getFullName();
			String age = String.valueOf(customer.getAge());
			
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("age", age);
			
			request.getRequestDispatcher("employee/customer.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			logger.error("Failed to convert string query id to integer", e);
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
			// Go to error page
		} catch (NullPointerException e) {
			e.printStackTrace();
			// Go to error page
		}
		
		System.out.println("Query: " + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
