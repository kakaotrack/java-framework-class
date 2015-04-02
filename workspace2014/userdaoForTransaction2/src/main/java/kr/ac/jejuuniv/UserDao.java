package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserDao {

	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PlatformTransactionManager transactionManager;

	public UserDao() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
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
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			deleteTestDataInternal(testName, testPassword);
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		} 
	}

	private void deleteTestDataInternal(String testName, String testPassword) {
		List<User> users = findAll();
		for (User user : users) {
			if (!user.getId().equals("1")) {
				if (user.getName().equals(testName) && user.getPassword().equals(testPassword))
					delete(user.getId());
			}
		}
	}

	public List<User> findAll() {
		String query = "select id, name, password from userinfo";
		List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper(User.class));
		return users;
	}

}