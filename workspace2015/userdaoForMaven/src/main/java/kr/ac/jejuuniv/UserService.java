package kr.ac.jejuuniv;

import java.sql.SQLException;

public interface UserService {

	User get(String id) throws SQLException;

	void add(User user) throws SQLException;

	void remove(String id) throws SQLException;

}
