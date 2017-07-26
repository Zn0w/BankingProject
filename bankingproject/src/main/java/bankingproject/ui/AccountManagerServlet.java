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
import bankingproject.domain.customer.money.Money;

/**
 * Servlet implementation class AccountManagerServlet
 */
public class AccountManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountManagerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		
		if (action.equals("deposit")) {
			String amount = request.getParameter("deposit_amount");
			
			AccountDao accountDao = new AccountDaoImpl();
			
			try {
				Account account = accountDao.getAccount(Integer.valueOf(id));
				
				account.getBalance().add(new Money(Double.valueOf(amount), account.getBalance().getCurrency()));
				account.update();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (DaoException e) {
				e.printStackTrace();
			}
		} else if (action.equals("withdraw")) {
			String amount = request.getParameter("withdraw_amount");
			
			AccountDao accountDao = new AccountDaoImpl();
			
			try {
				Account account = accountDao.getAccount(Integer.valueOf(id));
				
				account.getBalance().subtract(new Money(Double.valueOf(amount), account.getBalance().getCurrency()));
				account.update();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (DaoException e) {
				e.printStackTrace();
			}
		} else {
			String transfer_id = request.getParameter("transfer_id");
			String amount = request.getParameter("transfer_amount");
			
			AccountDao accountDao = new AccountDaoImpl();
			
			try {
				Account accountFrom = accountDao.getAccount(Integer.valueOf(id));
				Account accountTo = accountDao.getAccount(Integer.valueOf(transfer_id));
				
				accountFrom.transfer(accountTo, new Money(Double.valueOf(amount), accountFrom.getBalance().getCurrency()));
				
				accountFrom.update();
				accountTo.update();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("AccountServlet?id=" + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
