package bankingproject;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LoggingTest {
	
	private final static Logger logger = Logger.getLogger(LoggingTest.class);
	
	@Test
	public void checkSimpleLogging() {
		logger.info("Testing");
		
		assertEquals(true, true);
	}
	
	@Test
	public void checkLevelsLogging() {
		logger.info("Testing");
		logger.trace("Testing");
		logger.debug("Testing");
		logger.warn("Testing");
		logger.error("Testing");
		logger.fatal("Testing");
		
		assertEquals(true, true);
	}
	
}
