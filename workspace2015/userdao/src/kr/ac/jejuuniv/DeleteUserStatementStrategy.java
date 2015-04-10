package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserStatementStrategy implements StatementStrategy {

	@Override
	public PreparedStatement makeStatement(Object obj, Connection connection) throws SQLException {
		PreparedStatement preparedStatement;
		String sql = "delete from userinfo where id = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, (String) obj);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

}
