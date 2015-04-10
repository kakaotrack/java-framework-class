package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public UserDao() {
	}

	public User get(final String id) throws SQLException {
		String sql = "select id, name, password from userinfo where id = ?";
		final String[] params = new String[] { id };
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(sql, params, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet resultSet, int rownum) throws SQLException {
					User user = new User();
					user.setId(resultSet.getString("id"));
					user.setName(resultSet.getString("name"));
					user.setPassword(resultSet.getString("password"));
					return user;
				}
				
			});
		} catch (EmptyResultDataAccessException e) {
		}
		return user;
	}

	public void add(final User user) throws SQLException {
		final String sql = "insert into userinfo(id, name, password) values (?, ?, ?)";
		final String[] params = new String[] { user.getId(), user.getName(), user.getPassword() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(final String id) throws SQLException {
		final String sql = "delete from userinfo where id = ?";
		final String[] params = new String[] { id };
		jdbcTemplate.update(sql, params);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
