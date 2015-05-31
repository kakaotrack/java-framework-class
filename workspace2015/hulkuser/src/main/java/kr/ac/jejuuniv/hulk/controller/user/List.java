package kr.ac.jejuuniv.hulk.controller.user;

import kr.ac.jejuuniv.hulk.model.User;
import kr.ac.jejuuniv.hulk.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class List {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public java.util.List<User> list() {
		return userService.list();
	}
}
