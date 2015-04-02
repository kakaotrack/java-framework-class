package kr.ac.jejuuniv;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;

	public UserDaoImpl() {
		super();
	}

	@Override
	public User get(final String id) {
		return sqlSession.<User>selectOne("findById", id);
	}

	@Override
	public void add(final User user) {
		sqlSession.insert("insert", user);
	}

	@Override
	public void delete(final String id) {
		sqlSession.insert("delete", id);
	}

	@Override
	public List<User> findAll() {
		return sqlSession.<User>selectList("findAll");
	}

	@Override
	@Transactional
	public void deleteTestData(String name, String password) throws Exception {
		List<User> users = findAll();
		for (User user : users) {
			if (!"1".equals(user.getId())) {
				if (user.getName().equals(name) && user.getPassword().equals(password)) {
					delete(user.getId());
				}
			}
		}
	}

	@Override
	public void removeTestData(String name, String password) throws Exception {
		deleteTestData(name, password);
	}

}