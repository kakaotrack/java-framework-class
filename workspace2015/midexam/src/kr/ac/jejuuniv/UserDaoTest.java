package kr.ac.jejuuniv;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	private UserDao userDao;

	@Before
	public void setup() {
		userDao = new UserDao();
	}

	
	@Test
	public void get() throws ClassNotFoundException, SQLException {
		String id = "hulk";
		String name = "허윤호";
		String password = "1111";
		User user = userDao.get(id);
		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(password, user.getPassword());
	}
	
}
