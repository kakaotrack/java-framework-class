package kr.ac.jejuuniv;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldServletRequestListener implements ServletRequestListener {
	private final static Logger logger = LoggerFactory.getLogger(HelloWorldServletRequestListener.class);

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		logger.info("************  request destroy *************");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		logger.info("************  request init *************");
		
	}

}
