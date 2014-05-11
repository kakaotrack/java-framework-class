package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see kr.ac.jejuuniv.UserDao#get(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see kr.ac.jejuuniv.UserDao#add(kr.ac.jejuuniv.User)
	 */
	@Override
	public void add(final User user) {
		final String query = "insert into userinfo(id, name, password) values (? , ? , ?)";
		final String[] params = new String[] { user.getId(), user.getName(), user.getPassword() };
		jdbcTemplate.update(query, params);
	}

	/* (non-Javadoc)
	 * @see kr.ac.jejuuniv.UserDao#delete(java.lang.String)
	 */
	@Override
	public void delete(final String id) {
		final String query = "delete from userinfo where id = ?";
		final String[] params = new String[] { id };
		jdbcTemplate.update(query, params);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see kr.ac.jejuuniv.UserDao#findAll()
	 */
	@Override
	public List<User> findAll() {
		String query = "select id, name, password from userinfo";
		return jdbcTemplate.<User>query(query, new BeanPropertyRowMapper(User.class));
	}

	/* (non-Javadoc)
	 * @see kr.ac.jejuuniv.UserDao#deleteTestData(java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteTestData(String name, String password) throws Exception {
		List<User> users = findAll();
		for(User user:users) {
			if(!"1".equals(user.getId())) {
				if(user.getName().equals(name) && user.getPassword().equals(password))
					delete(user.getId());
			}
		}
	}



}