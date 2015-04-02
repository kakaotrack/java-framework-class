package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface UserDao {

	public abstract User get(String id);

	public abstract void add(User user);

	public abstract void delete(String id);

	public abstract List<User> findAll();

}