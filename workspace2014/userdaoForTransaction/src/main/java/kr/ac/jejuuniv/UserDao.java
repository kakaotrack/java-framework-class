package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class UserDao {

	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

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
			queryForObject = jdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper(User.class));
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

	public void deleteTestData(String testName, String testPassword) throws Exception {
		TransactionSynchronizationManager.initSynchronization();
		Connection connection = DataSourceUtils.getConnection(dataSource);
		connection.setAutoCommit(false);
		List<User> users = findAll();
		try {
			for (User user : users) {
				if (!user.getId().equals("1")) {
					if (user.getName().equals(testName) && user.getPassword().equals(testPassword))
						delete(user.getId());
				}
			}
		} catch (Exception e) {
			connection.rollback();
			throw e;
		} finally {
			DataSourceUtils.releaseConnection(connection, dataSource);
			TransactionSynchronizationManager.unbindResource(dataSource);
			TransactionSynchronizationManager.clearSynchronization();
		}

	}

	public List<User> findAll() {
		String query = "select id, name, password from userinfo";
		List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper(User.class));
		return users;
	}

}
