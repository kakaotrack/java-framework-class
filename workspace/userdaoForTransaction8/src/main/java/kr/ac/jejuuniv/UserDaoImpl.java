package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;


	public UserDaoImpl() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
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

	@Override
	public void add(final User user) {
		final String query = "insert into userinfo(id, name, password) values (? , ? , ?)";
		final String[] params = new String[] { user.getId(), user.getName(), user.getPassword() };
		jdbcTemplate.update(query, params);
	}

	@Override
	public void delete(final String id) {
		final String query = "delete from userinfo where id = ?";
		final String[] params = new String[] { id };
		jdbcTemplate.update(query, params);
	}

	@Override
	public void deleteTestData(String testName, String testPassword) {
		List<User> users = findAll();
		for (User user : users) {
			if (!user.getId().equals("1")) {
				if (user.getName().equals(testName) && user.getPassword().equals(testPassword))
					delete(user.getId());
			}
		}
	}

	@Override
	public List<User> findAll() {
		String query = "select id, name, password from userinfo";
		List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper(User.class));
		return users;
	}

}