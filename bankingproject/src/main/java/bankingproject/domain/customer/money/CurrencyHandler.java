package bankingproject.domain.customer.money;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class CurrencyHandler {
	
	// TODO: use dynamic currency exchange rate
	private static final double USDToRUB = 60.80;
	private static final double USDToEUR = 0.87;
	private static final double USDToGBP = 0.78;
	
	private static final Logger logger = Logger.getLogger(CurrencyHandler.class);
	
	public static double getCurrencyCoefficient(String from, String to) throws IllegalCurrencyException {
		logger.info("Converting " + from + " to " + to);
		
		if (!isLegalCurrencyString(from) || !isLegalCurrencyString(to)) {
			logger.error("Passed currency string(s) is illegal");
			throw new IllegalCurrencyException("Passed currency string(s) is illegal");
		}
		else {
			if (from.equals("USD") && to.equals("RUB")) {
				logger.info("Got coefficient");
				return USDToRUB;
			} else if (from.equals("RUB") && to.equals("USD")) {
				logger.info("Got coefficient");
				return Math.pow(USDToRUB, -1);
			} else if (from.equals("USD") && to.equals("EUR")) {
				logger.info("Got coefficient");
				return USDToEUR;
			} else if (from.equals("EUR") && to.equals("USD")) {
				logger.info("Got coefficient");
				return Math.pow(USDToRUB, -1);
			} else if (from.equals("USD") && to.equals("GBP")) {
				logger.info("Got coefficient");
				return USDToGBP;
			} else if (from.equals("GBP") && to.equals("USD")) {
				logger.info("Got coefficient");
				return Math.pow(USDToGBP, -1);
			}
			
			logger.error("Failed to find coefficient");
			
			return 0;
		}
	}
	
	private static boolean isLegalCurrencyString(String currency) {
		if (currency.equals("USD") || currency.equals("EUR") || currency.equals("GBP") || currency.equals("RUB")) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
