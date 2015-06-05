package kr.ac.jejuuniv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("user")
@RequestMapping("/abc")
public class AnnotationController {
	private static final Logger logger = LoggerFactory.getLogger(AnnotationController.class);
	@RequestMapping("/annotation")
	public void annotation(ModelAndView modelAndView, User user ) {
		String n = null;
		n.toString();
		modelAndView.addObject("test", "Hello World");
		logger.info("**** default annotation handler mapping *****");
	}
	
//	@RequestMapping("/test/{name}/password/{password}")
//	public void test(@PathVariable("name") String name ) {
//		
//	}
//	
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception e) {
		return new ModelAndView("error").addObject("e", e);
	}
}
