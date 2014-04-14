package kr.ac.jejuuniv;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public UserDao() {
	}

	public User get(final String id) {
		String query = "select id, name, password from userinfo where id = ?";
		String[] params = new String[] { id };
		User queryForObject;
		try {
			queryForObject = jdbcTemplate.queryForObject(query, params, new RowMapper<User>() {

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
			return null;
		}
		return queryForObject;
	}

	public void add(final User user) {
		final String query = "insert into userinfo(id, name, password) values (? , ? , ?)";
		final String[] params = new String[] { user.getId(), user.getName(), user.getPassword() };
		jdbcTemplate.update(query, params);
	}

	public void delete(final String id) {
		final String query = "delete from userinfo where id = ?";
		final String[] params = new String[] { id };
		jdbcTemplate.update(query, params);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
