package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcContext {
	
	private DataSource dataSource;

	public void update(final String sql, final String[] params) throws SQLException {
		StatementStrategy statementStrategy = new StatementStrategy() {
			@Override
			public PreparedStatement makeStatement(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				for (int i = 1; i <= params.length; i++) {
					preparedStatement.setString(i, params[i - 1]);
				}
				return preparedStatement;
			}
		};
		jdbcContextWithStatementStrategyForUpdate(statementStrategy);
	}


	public User jdbcContextWithStatementStrategyForSelect(StatementStrategy statementStrategy) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = statementStrategy.makeStatement(connection);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	public void jdbcContextWithStatementStrategyForUpdate(StatementStrategy statementStrategy) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = statementStrategy.makeStatement(connection);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
