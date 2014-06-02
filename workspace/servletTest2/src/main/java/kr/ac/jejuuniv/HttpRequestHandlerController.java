package kr.ac.jejuuniv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

@Component("/httpRequestHandler")
public class HttpRequestHandlerController implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().println("<h2>Hello World</h2>");
	}

}
