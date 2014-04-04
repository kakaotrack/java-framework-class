package kr.ac.jejuuniv;

import java.sql.SQLException;

public class UserDao {

	private JdbcContext jdbcContext;

	public UserDao() {
	}

	public User get(String id) throws SQLException {
		StatementStrategy statementStrategy = new GetStatementStrategy(id);
		return jdbcContext.jdbcContextWithStatementStrategyForSelect(statementStrategy);
	}


	public void add(User user) throws SQLException {
		StatementStrategy statementStrategy = new AddStatementStrategy(user);
		jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
	}



	public void delete(String id) throws SQLException {
		StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
		jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
	}

	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
	

}
