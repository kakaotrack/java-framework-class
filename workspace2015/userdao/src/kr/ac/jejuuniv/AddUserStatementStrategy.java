package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUserStatementStrategy implements StatementStrategy {

	@Override
	public PreparedStatement makeStatement(Object obj, Connection connection) throws SQLException {
		String sql = "insert into userinfo(id, name, password) values (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		User user = (User) obj;
		preparedStatement.setString(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPassword());
		return preparedStatement;
	}

}
