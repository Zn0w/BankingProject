package bankingproject.ui;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				
				saveTransactionInfo("DEPOSIT " + amount + " " + account.getBalance().getCurrency() + " TO " + id);
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
				
				saveTransactionInfo("WITHDRAW " + amount + " " + account.getBalance().getCurrency() + " FROM " + id);
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
				
				saveTransactionInfo("TRANSFER " + amount + " " + accountFrom.getBalance().getCurrency() + " FROM " + id + " TO " + transfer_id);
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
	
	private void saveTransactionInfo(String actionInfo) {
		DateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		System.out.println(dateFormat.format(date) + " " + actionInfo);
	}

}
