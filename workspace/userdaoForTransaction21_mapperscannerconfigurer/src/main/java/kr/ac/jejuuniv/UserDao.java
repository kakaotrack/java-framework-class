package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface UserDao {

	public abstract User get(String id);

	public abstract void add(User user);

	public abstract void delete(String id);

	public abstract List<User> findAll();

	public abstract void deleteTestData(String name, String password) throws Exception;

	public abstract void removeTestData(String name, String password) throws Exception;

}