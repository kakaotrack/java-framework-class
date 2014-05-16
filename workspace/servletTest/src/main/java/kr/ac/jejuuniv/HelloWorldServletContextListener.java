package kr.ac.jejuuniv;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldServletContextListener implements ServletContextListener {

	private final static Logger logger = LoggerFactory.getLogger(HelloWorldServletContextListener.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("***********  context init ****************");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("***********  context destroy ****************");

	}

}
