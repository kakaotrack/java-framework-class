package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	List<User> findAll();

	void insert(User user);

	void delete(String id);

	User findById(String id);

	void update(User user);

}
