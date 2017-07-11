package bankingproject.domain.customer.money;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class CurrencyHandler {
	
	private static final Logger logger = Logger.getLogger(CurrencyHandler.class);
	
	public static Double getCurrencyCoefficient(String from, String to) throws IllegalCurrencyException {
		logger.info("Converting " + from + " to " + to);
		
		if (!isLegalCurrencyString(from) || !isLegalCurrencyString(to)) {
			logger.error("Passed currency string(s) is illegal");
			throw new IllegalCurrencyException("Passed currency string(s) is illegal");
		}
		else {
			//Yahoo Finance API
            URL url;
			try {
				url = new URL("http://finance.yahoo.com/d/quotes.csv?f=l1&s="+ from + to + "=X");
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            String line = reader.readLine();
	            
	            logger.trace("Got coefficient: " + line);
	            
	            if (line.length() > 0) {
	                return Double.parseDouble(line);	
	            }
	            
	            reader.close();
			} catch (MalformedURLException e) {
				logger.error("Wrong URL", e);
			} catch (IOException e) {
				logger.error("Failed to read line", e);
			}
		}
		
		return null;
	}
	
	private static boolean isLegalCurrencyString(String currency) {
		if (currency.equals("USD") || currency.equals("EUR") || currency.equals("FRN") || currency.equals("RUB")) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
