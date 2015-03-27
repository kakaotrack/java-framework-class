package kr.ac.jejuuniv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("helloModel")
@RequestMapping("/create")
public class Create {
	@RequestMapping
	public void create(HelloModel helloModel) {
		System.out.println(helloModel.getName());
		System.out.println(helloModel.getHello());
		helloModel.setHello("hello !!!");
	}

}
