package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStatementStrategy implements StatementStrategy {
	private User user;

	public AddStatementStrategy(User user) {
		this.user = user;
	}

	@Override
	public PreparedStatement makeStatement(Connection connection) throws SQLException {
		String query = "insert into userinfo(id, name, password) values (? , ? , ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPassword());
		return preparedStatement;
	}

}
