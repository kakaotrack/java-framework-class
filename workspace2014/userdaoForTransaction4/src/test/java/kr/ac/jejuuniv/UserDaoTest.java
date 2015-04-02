package kr.ac.jejuuniv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.List;
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
//		userDao = context.getBean("userDao", UserDao.class);
		InvocationHandler handler = context.getBean("userHandler", InvocationHandler.class);
		userDao = (UserDao)Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{UserDao.class}, handler);
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
		String id = String.valueOf(new Random().nextInt(10000));

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
	
	@Test
	public void deleteTestData() throws Exception {
		userDao.deleteTestData(name, password);
		List<User> users = userDao.findAll();
		for(User user : users) {
			if(!user.getId().equals("1")) {
				assertNotEquals(name, user.getName());
				assertNotEquals(password , user.getPassword());
			}
		}
	}
	
	
	@Test
	public void failTransaction() throws Exception {

		String midId = String.valueOf(new Random().nextInt(1000));
		String failTestId = "1" + midId + "failTest";
		String successTestId = "0" + midId + "successTest";

		User failUser = new User();
		failUser.setId(failTestId);
		userDao.add(failUser);
		User successUser = new User();
		successUser.setId(successTestId);
		successUser.setName(name);
		successUser.setPassword(password);
		userDao.add(successUser);
		try {
			userDao.deleteTestData(name, password);
		} catch (Exception e) {
		}
		assertNotNull(userDao.get(successTestId));
	}
	
	@Test
	public void findAll() {
		List<User> users = userDao.findAll();
		assertTrue(users.size() > 0);
	}
	
}
