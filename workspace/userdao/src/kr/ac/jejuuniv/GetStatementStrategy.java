package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetStatementStrategy implements StatementStrategy {
	private String id;

	public GetStatementStrategy(String id) {
		this.id = id;
	}

	@Override
	public PreparedStatement makeStatement(Connection connection) throws SQLException {
		String query = "select id, name, password from userinfo where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, (String) id);
		return preparedStatement;
	}

}
