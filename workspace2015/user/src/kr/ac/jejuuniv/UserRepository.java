package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	List<User> findAll();

	void insert(User user);

	User findById(String id);

	void update(User user);

}
