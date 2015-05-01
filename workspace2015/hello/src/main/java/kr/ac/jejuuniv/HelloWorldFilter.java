package kr.ac.jejuuniv;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("**** filter destroy *******");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("***** filter start *********");
		chain.doFilter(req, res);
		System.out.println("***** filter end *********");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("**** filter init *******");
	}

}
