package kr.ac.jejuuniv;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Random;

import kr.ac.jejuuniv.repository.UserDao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/daoFactory.xml")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	

	@Test
	public void get() throws ClassNotFoundException, SQLException {
		String id = "hulk";
		String name = "허윤호";
		String password = "1111";
		User user = userDao.findById(id);
		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(password, user.getPassword());
	}
	
	@Test
	public void add() throws ClassNotFoundException, SQLException {
		User user = new User();
		String id = String.valueOf(new Random().nextInt());
		String name = "허윤호";
		String password = "111";

		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		
		userDao.insert(user);
		User addedUser = userDao.findById(id);
		assertEquals(id, addedUser.getId());
		assertEquals(name, addedUser.getName());
		assertEquals(password, addedUser.getPassword());
	}
	
	@Test
	public void delete() throws SQLException {
		User user = new User();
		String id = String.valueOf(new Random().nextInt());
		String name = "허윤호";
		String password = "111";
		
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		
		userDao.insert(user);
		
		userDao.delete(id);
		
		assertNull(userDao.findById(id));
	}
}
