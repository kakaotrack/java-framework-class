package kr.ac.jejuuniv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	private String name;
	private String password;
	private UserDao userDao;
	
	@Before
	public void setup() {
		name = "허윤호";
		password = "1111";
		ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
		userDao = context.getBean("userDao", UserDao.class);
	}

	@Test
	public void get() throws SQLException, ClassNotFoundException {
		String id = "1";
		User user = userDao.get(id);
		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(password, user.getPassword());
	}
	
	@Test
	public void add() throws ClassNotFoundException, SQLException {
		User user = new User();
		String id = String.valueOf(new Random().nextInt());

		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		userDao.add(user);
		User addedUser = userDao.get(id);
		assertEquals(id, addedUser.getId());
		assertEquals(name, addedUser.getName());
		assertEquals(password, addedUser.getPassword());
	}
	
	@Test
	public void delete() throws SQLException {
		User user = new User();
		String id = String.valueOf(new Random().nextInt());
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		userDao.add(user);
		
		userDao.delete(id);
		User deletedUser = userDao.get(id);
		assertNull(deletedUser);
		
	}
}
