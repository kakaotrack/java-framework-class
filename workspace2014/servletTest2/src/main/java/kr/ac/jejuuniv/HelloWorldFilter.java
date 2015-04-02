package kr.ac.jejuuniv;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldFilter implements Filter{
	
	private final static Logger logger = LoggerFactory.getLogger(HelloWorldFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("****************  filter init ****************");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("****************  filter start ****************");
		chain.doFilter(request, response);
		logger.info("****************  filter end ****************");
		
	}

	@Override
	public void destroy() {
		logger.info("****************  filter destroy ****************");
		
	}

}
