package kr.ac.jejuuniv;

import java.util.List;

public interface UserDao {

	public abstract User get(String id);

	public abstract void add(User user);

	public abstract void delete(String id);

//	public abstract void deleteTestData(String testName, String testPassword) throws Exception;

	public abstract List<User> findAll();

//	void removeTestData(String name, String password) throws Exception;

}