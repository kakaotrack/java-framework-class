package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class UserList {
	@Autowired
	private UserService userService;

	@RequestMapping
	public List<User> list() {
		return userService.list();
	}
}
