package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.User;

public interface UserService {

	List<User> list();

	void remove(String id);

	User get(String id);

	void save(User user);

}
