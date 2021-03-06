package bankingproject.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bankingproject.dao.DaoException;
import bankingproject.dao.customer.CustomerDao;
import bankingproject.dao.customer.CustomerDaoImpl;
import bankingproject.domain.customer.Account;
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
			
			List<Account> accounts = customer.getAccounts();
			String[][] accountsInfo = new String[accounts.size()][3];
			for (Account account : accounts) {
				accountsInfo[accounts.indexOf(account)][0] = String.valueOf(account.getId());
				accountsInfo[accounts.indexOf(account)][1] = String.valueOf(account.getBalance().getAmount());
				accountsInfo[accounts.indexOf(account)][2] = account.getBalance().getCurrency();
			}
			
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("age", age);
			request.setAttribute("accounts", accountsInfo);
			
			request.getRequestDispatcher("employee/customer.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			logger.error("Failed to convert string query id to integer", e);
			e.printStackTrace();
		} catch (DaoException e) {
			// Go to error page
		} catch (NullPointerException e) {
			e.printStackTrace();
			handleCustomerNotFound(response);
		}
		
		System.out.println("Query: " + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void handleCustomerNotFound(HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Customer not found</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align = 'right'>" +
							"<form action='LogoutServlet'>" +
								"<input type = 'submit' value = 'Log out'>" +
							"</form>" +
							"<form action='employee/mainPage.jsp'>" +
								"<input type = 'submit' value = 'Go to main page'>" +
							"</form>" +
						"</div>");		
			out.println("<div align = 'center'>");
			out.println("<br><br><br><br>");
			out.println("<h1>Customer not found</h1>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
