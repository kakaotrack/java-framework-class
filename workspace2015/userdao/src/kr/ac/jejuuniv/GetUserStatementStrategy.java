package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetUserStatementStrategy implements StatementStrategy {
	private String id;

	public GetUserStatementStrategy(String id) {
		this.id = id;
	}

	@Override
	public PreparedStatement makeStatement(Connection connection) throws SQLException {
		String sql = "select id, name, password from userinfo where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		return preparedStatement;
	}

}
