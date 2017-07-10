package bankingproject.ui;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class CustomerListServlet
 */
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(CustomerListServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao customerDao = new CustomerDaoImpl();
		
		try {
			logger.trace("Get customers");
			List<Customer> customers = customerDao.getCustomers();
			
			String[][] customerInfo = new String[customers.size()][3];
			
			for (Customer customer : customers) {
				customerInfo[customers.indexOf(customer)][0] = new Integer(customer.getId()).toString();
				customerInfo[customers.indexOf(customer)][1] = customer.getName().getFullName();
				customerInfo[customers.indexOf(customer)][2] = new Integer(customer.getAge()).toString();
			}
			
			request.setAttribute("customers", customerInfo);
			
			request.getRequestDispatcher("/employee/customers.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
