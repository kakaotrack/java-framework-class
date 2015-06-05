package kr.ac.jejuuniv;

import java.sql.SQLException;

import kr.ac.jejuuniv.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User get(String id) throws SQLException {
		return userDao.findById(id);
	}

	@Override
	public void add(User user) throws SQLException {
		userDao.insert(user);
	}

	@Override
	public void remove(String id) throws SQLException {
		userDao.delete(id);
	}

}
