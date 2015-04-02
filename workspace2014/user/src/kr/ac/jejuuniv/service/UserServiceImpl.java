package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.User;
import kr.ac.jejuuniv.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> list() {
		return userRepository.findAll();
	}

	private void create(User user) {
		userRepository.insert(user);
	}

	@Override
	public void remove(String id) {
		userRepository.delete(id);

	}

	@Override
	public User get(String id) {
		return userRepository.findById(id);
	}

	@Override
	public void save(User user) {
		User existUser = get(user.getId());
		if (existUser == null)
			create(user);
		else
			modify(user);
	}

	private void modify(User user) {
		userRepository.update(user);
	}

}
