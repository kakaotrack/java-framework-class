package kr.ac.jejuuniv;

import java.util.List;

public interface UserDaoMapper {
	public abstract User findById(String id);

	public abstract void insert(User user);

	public abstract void delete(String id);

	public abstract List<User> findAll();
}
