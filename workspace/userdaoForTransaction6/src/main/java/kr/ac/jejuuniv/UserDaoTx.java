package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserDaoTx implements UserDao{
	@Autowired
	private PlatformTransactionManager transactionManager;

	private UserDao userDao;

	@Override
	public User get(String id) {
		return getUserDao().get(id);
	}

	@Override
	public void add(User user) {
		getUserDao().add(user);
	}

	@Override
	public void delete(String id) {
		getUserDao().delete(id);
	}

	@Override
	public void deleteTestData(String testName, String testPassword) throws Exception {
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			getUserDao().deleteTestData(testName, testPassword);
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		} 
		getUserDao().deleteTestData(testName, testPassword);
	}

	@Override
	public List<User> findAll() {
		return getUserDao().findAll();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
