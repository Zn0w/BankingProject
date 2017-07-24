package bankingproject.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingproject.dao.DaoException;
import bankingproject.dao.account.AccountDao;
import bankingproject.dao.account.AccountDaoImpl;
import bankingproject.domain.customer.Account;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		AccountDao accountDao = new AccountDaoImpl();
		try {
			Account account = accountDao.getAccount(Integer.valueOf(id));
			
			String balance = account.getBalance().getAmount() + " " + account.getBalance().getCurrency();
			String owner = String.valueOf(account.getOwnerId());
			
			request.setAttribute("id", id);
			request.setAttribute("balance", balance);
			request.setAttribute("owner", owner);
			
			request.getRequestDispatcher("employee/account.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		System.out.println("Account ID: " + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
