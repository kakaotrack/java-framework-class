package kr.ac.jejuuniv.repository;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.User;

@Repository
public interface UserDao {

	User findById(String id);

	void insert(User user);

	void delete(String id);

}
