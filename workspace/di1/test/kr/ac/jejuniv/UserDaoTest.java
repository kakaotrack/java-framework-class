package kr.ac.jejuniv;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	private String name;
	private String password;
//	private DaoFactory daoFactory;
	private UserDao userDao;
	
	@Before
	public void setup() {
//		daoFactory = new DaoFactory();
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
		ApplicationContext applicationContext = new GenericXmlApplicationContext("daoFactory.xml");
		this.userDao = applicationContext.getBean("userDao", UserDao.class);
		name = "허윤호";
		password = "1111";
	}

	@Test
	public void get() throws SQLException, ClassNotFoundException {
		String id = "1";
		User user = userDao.get(id);
		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(password, user.getPassword());
//		userDao = new UserDao(new NConnectionMaker());
//		user = userDao.get(id);
//		assertEquals(id, user.getId());
//		assertEquals(name, user.getName());
//		assertEquals(password, user.getPassword());
	}
	
	@Test
	public void add() throws SQLException, ClassNotFoundException {
		User user = new User();
		String id = String.valueOf(new Random().nextInt());
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		userDao.add(user);
		User addedUser = userDao.get(id);
		assertEquals(user.getId(), addedUser.getId());
		assertEquals(user.getName(), addedUser.getName());
		assertEquals(user.getPassword(), addedUser.getPassword());
//		userDao = new UserDao(new NConnectionMaker());
//		userDao.add(user);
//		addedUser = userDao.get(id);
//		assertEquals(user.getId(), addedUser.getId());
//		assertEquals(user.getName(), addedUser.getName());
//		assertEquals(user.getPassword(), addedUser.getPassword());
	}

}
