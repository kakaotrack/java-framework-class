package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserStatementStrategy implements StatementStrategy {
	private String id;

	public DeleteUserStatementStrategy(String id) {
		this.id = id;
	}

	@Override
	public PreparedStatement makeStatement(Connection connection) throws SQLException {
		PreparedStatement preparedStatement;
		String sql = "delete from userinfo where id = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

}
