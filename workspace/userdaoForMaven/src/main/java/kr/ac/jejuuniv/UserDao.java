package kr.ac.jejuuniv;

import java.util.List;

public interface UserDao {

	public abstract User get(String id);

	public abstract void add(User user);

	public abstract void delete(String id);

	public abstract List<User> findAll();

	public abstract void deleteTestData(String name, String password) throws Exception;

}