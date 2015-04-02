package kr.ac.jejuuniv;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

public class TransactionFactoryBean implements FactoryBean<Object> {
	private Class<?> daoInterface;
	private String[] patterns;
	private Object target;
	private PlatformTransactionManager transactionManager;

	@Override
	public Object getObject() throws Exception {
		TransactionInvocationHandler handler = new TransactionInvocationHandler();
		handler.setPatterns(getPatterns());
		handler.setTarget(getTarget());
		handler.setTransactionManager(getTransactionManager());
		return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{getDaoInterface()}, handler);
	}

	@Override
	public Class<?> getObjectType() {
		return this.getDaoInterface();
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public Class<?> getDaoInterface() {
		return daoInterface;
	}

	public void setDaoInterface(Class<?> daoInterface) {
		this.daoInterface = daoInterface;
	}

	public String[] getPatterns() {
		return patterns;
	}

	public void setPatterns(String[] patterns) {
		this.patterns = patterns;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

}
