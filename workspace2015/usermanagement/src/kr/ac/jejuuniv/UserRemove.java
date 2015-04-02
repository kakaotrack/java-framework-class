package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remove")
public class UserRemove {
	
	
	@Autowired
	private UserService userService;

	@RequestMapping
	public String remove(String id) {
		userService.remove(id);
		return "redirect:list";
	}
}
