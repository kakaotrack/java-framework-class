package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
	
	private String id;

	public DeleteStatementStrategy(String id) {
		this.id = id;
	}

	@Override
	public PreparedStatement makeStatement(Connection connection) throws SQLException {
		PreparedStatement preparedStatement;
		String query = "delete from userinfo where id = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, (String) id);
		return preparedStatement;

	}

}
