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
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl() {
		super();
	}


	@Override
	public User get(final String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user;
		try {
			user = sqlSession.selectOne("findById", id);
		} finally {
			sqlSession.close();
		}
		return user;
	}

	@Override
	public void add(final User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert("insert", user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void delete(final String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert("delete", id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<User> findAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> users;
		try {
			users = sqlSession.selectList("findAll");
		} finally {
			sqlSession.close();
		}
		return users;
	}

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

	@Override
	public void removeTestData(String name, String password) throws Exception {
		deleteTestData(name, password);
	}

}