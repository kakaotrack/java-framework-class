package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetUserStatementStrategy implements StatementStrategy {

	@Override
	public PreparedStatement makeStatement(Object obj, Connection connection) throws SQLException {
		String sql = "select id, name, password from userinfo where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, (String) obj);
		return preparedStatement;
	}

}
