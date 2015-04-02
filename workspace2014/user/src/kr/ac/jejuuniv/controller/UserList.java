package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.User;
import kr.ac.jejuuniv.service.UserService;

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
