package main.java;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
	private final static Logger LOGGER = Logger.getLogger(MyLogger.class.getName());

	
	public static Logger getLogger() {
		LOGGER.setLevel(Level.INFO);
		return LOGGER;
	}
	
}
