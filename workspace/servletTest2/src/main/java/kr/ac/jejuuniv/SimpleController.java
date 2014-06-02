package kr.ac.jejuuniv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

@Component("simpleController")
public class SimpleController implements Controller{
	
	@Autowired
	HelloPrinter helloPrinter;
	
	@Autowired
	MarshallingView marshallingView;
	
	@Autowired
	MappingJacksonJsonView mappingJacksonJsonView;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("simpleController");
		modelAndView.addObject(helloPrinter.getModel());
		return modelAndView;
	}

}
