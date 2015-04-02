package kr.ac.jejuuniv;

import java.util.List;

public interface UserService {

	List<User> list();

	void save(User user);

	User get(String id);

	void remove(String id);

}
