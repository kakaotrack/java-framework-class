package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/annotation")
@SessionAttributes("helloModel")
public class AnnotationController {

	@Autowired
	HelloPrinter helloPrinter;

	@RequestMapping("/hello")
	public void hello(@ModelAttribute HelloModel helloModel) {
		System.out.println(helloModel.getName());
		System.out.println(helloModel.getHello());
	}
}
