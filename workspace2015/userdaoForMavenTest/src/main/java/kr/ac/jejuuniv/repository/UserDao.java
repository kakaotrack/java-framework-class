package kr.ac.jejuuniv.repository;

import kr.ac.jejuuniv.User;


public interface UserDao {

	public User findById(final String id); 
	public void insert(final User user); 
	public void delete(final String id); 
}
