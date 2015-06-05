package kr.ac.jejuuniv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/session")
public class SessionController {
	@RequestMapping
	public ModelAndView session(HttpServletRequest req, HttpServletResponse res, String name, String password) {
		HttpSession session = req.getSession();
		User oldUser = (User) session.getAttribute("user");
		User user = new User();
		user.setId(1);
		user.setName(name);
		user.setPassword(password);
		session.setAttribute("user", user);
		return new ModelAndView().addObject("user", oldUser);
	}
}
