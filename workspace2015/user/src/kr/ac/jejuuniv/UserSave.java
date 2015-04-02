package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/save")
public class UserSave {
	@Autowired
	private UserService userService;

	@RequestMapping
	public String save(User user) {
		userService.save(user);
		return "redirect:/list";
	}
}
