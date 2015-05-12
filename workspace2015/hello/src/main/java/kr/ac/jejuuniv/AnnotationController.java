package kr.ac.jejuuniv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/annotation")
public class AnnotationController {
	private static final Logger logger = LoggerFactory.getLogger(AnnotationController.class);
	@RequestMapping
	public void annotation(ModelAndView modelAndView) {
		modelAndView.addObject("test", "Hello World");
		logger.info("**** default annotation handler mapping *****");
	}
}
