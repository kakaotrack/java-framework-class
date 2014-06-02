package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnotationController {
	
	
	
	@Autowired
	HelloPrinter helloPrinter;

	@RequestMapping("/annotation")
	public HelloModel hello() {
		return helloPrinter.getModel();
	}
}
