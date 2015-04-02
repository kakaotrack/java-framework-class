package kr.ac.jejuuniv;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/daoFactory.xml")
public class UserDaoTest {
	private String name;
	private String password;
	@Autowired
	private UserDao userDao;
	
	@Before
	public void setup() {
		name = "허윤호";
		password = "1111";
//		ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
//		userDao = context.getBean("userDao", UserDao.class);
//		InvocationHandler transactionHandler = context.getBean("transactionHandler", InvocationHandler.class);
//		userDao = (UserDao) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{UserDao.class}, transactionHandler);
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
	
	//TODO 나중에...
//	@Test
//	public void deleteTestData() {
//		userDao.deleteTestData(name, password);
//		List<User> users = userDao.findAll();
//		for(User user : users) {
//			if(!"1".equals(user.getId())) {
//				assertFalse(name.equals(user.getName())&&password.equals(user.getPassword()));
//			}
//		}
//	}
	
	@Test
	public void findAll() {
		List<User> users = userDao.findAll();
		assertTrue(users.size() > 0);
	}
	
//	
//	@Test
//	public void successTransaction() throws Exception {
//		String successId = "11" + new Random().nextInt(10000);
//		User user = new User();
//		user.setId(successId);
//		user.setName(name);
//		user.setPassword(password);
//		userDao.add(user);
//		String failId = "21" + new Random().nextInt(10000);
//		user = new User();
//		user.setId(failId);
//		user.setName(name);
//		userDao.add(user);
//		try {
//			userDao.deleteTestData(name, password);
//		} catch (NullPointerException e) {
//		} catch (InvocationTargetException e) {
//		}
//		assertNotNull(userDao.get(successId));
//	}
//	
//	
//	@Test
//	public void failTransaction() throws Exception {
//		String successId = "11" + new Random().nextInt(10000);
//		User user = new User();
//		user.setId(successId);
//		user.setName(name);
//		user.setPassword(password);
//		userDao.add(user);
//		String failId = "21" + new Random().nextInt(10000);
//		user = new User();
//		user.setId(failId);
//		user.setName(name);
//		userDao.add(user);
//		try {
//			userDao.removeTestData(name, password);
//		} catch (NullPointerException e) {
//		} catch (InvocationTargetException e) {
//		}
//		assertNull(userDao.get(successId));
//	}
//	
//
//	@Override
//	@Transactional
//	public void deleteTestData(String name, String password) throws Exception {
//		List<User> users = findAll();
//		for (User user : users) {
//			if (!"1".equals(user.getId())) {
//				if (user.getName().equals(name) && user.getPassword().equals(password)) {
//					delete(user.getId());
//				}
//			}
//		}
//	}
//
//	@Override
//	public void removeTestData(String name, String password) throws Exception {
//		deleteTestData(name, password);
//	}
//	
	
	@Test
	public void reflectionTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class c = Class.forName("kr.ac.jejuuniv.User");
		Object obj = c.newInstance();
		Method method = c.getDeclaredMethod("setName", String.class);
		method.invoke(obj, "허윤호");
		Method getMethod = c.getDeclaredMethod("getName");
		System.out.println(getMethod.invoke(obj));
	}
	
}
