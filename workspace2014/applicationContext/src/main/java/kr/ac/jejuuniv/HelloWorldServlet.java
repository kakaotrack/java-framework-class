package kr.ac.jejuuniv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloWorldServlet extends GenericServlet{

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldServlet.class);

	@Override
	public void destroy() {
		logger.info("**********  destroy *************");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		logger.info("**********   init **************");
		super.init();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		logger.info("*********   service  ***************");
		logger.info(getServletContext().getInitParameter("contextConfigLocation"));
		PrintWriter writer = res.getWriter();
		writer.println("<h2>Hello World!!!</h2>");
	}

}
