package bankingproject.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingproject.dao.DaoException;
import bankingproject.dao.customer.CustomerDao;
import bankingproject.dao.customer.CustomerDaoImpl;
import bankingproject.domain.NameContainer;

/**
 * Servlet implementation class CreateCustomerServlet
 */
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NameContainer name = new NameContainer(request.getParameter("first name"), request.getParameter("last name"));
		int age = Integer.valueOf(request.getParameter("age"));
		
		CustomerDao customerDao = new CustomerDaoImpl();
		try {
			customerDao.createCustomer(name.getFullName(), age);
		} catch (DaoException e) {
			e.printStackTrace();
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
