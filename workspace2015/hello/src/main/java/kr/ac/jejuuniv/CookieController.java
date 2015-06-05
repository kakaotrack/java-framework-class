package kr.ac.jejuuniv;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cookie")
public class CookieController {
	@RequestMapping
	public ModelAndView cookie(HttpServletRequest req, HttpServletResponse res, String name) {
		String myCookie = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if ("myCookie".equals(cookie.getName()))
					myCookie = cookie.getValue();
			}

		Cookie cookie = new Cookie("myCookie", name);
		cookie.setMaxAge(60000);
		res.addCookie(cookie);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myCookie", myCookie);
		return modelAndView;
	}
}
