package kr.ac.jejuuniv.hulk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.hulk.dao.UserDao;
import kr.ac.jejuuniv.hulk.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> list() {
		return userDao.findAll();
	}

}
