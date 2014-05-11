package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserDaoTx implements UserDao {

	private PlatformTransactionManager transactionManager;
	private UserDao userDao;

	public UserDaoTx() {
	}

	public void deleteTestData(String name, String password) throws Exception {
		TransactionStatus status = getTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			getUserDao().deleteTestData(name, password);
			getTransactionManager().commit(status);
		} catch (Exception e) {
			getTransactionManager().rollback(status);
			throw e;
		} 
	}
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

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
