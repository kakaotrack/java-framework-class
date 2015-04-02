package kr.ac.jejuuniv;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

public class TransactionFactoryBean implements FactoryBean<Object>{

	private String[] patterns;
	private Object target;
	private Class<?> daoInterface;
	private Advice advice;


	@Override
	public Object getObject() throws Exception {
		TransactionInvocationHandler transactionHandler = new TransactionInvocationHandler();
		transactionHandler.setPatterns(getPatterns());
		transactionHandler.setTarget(getTarget());
		transactionHandler.setAdvice(getAdvice());
		return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{getDaoInterface()}, transactionHandler);
	}

	@Override
	public Class<?> getObjectType() {
		return getDaoInterface();
	}

	@Override
	public boolean isSingleton() {
		return false;
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

	public Class<?> getDaoInterface() {
		return daoInterface;
	}

	public void setDaoInterface(Class<?> daoInterface) {
		this.daoInterface = daoInterface;
	}

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

}
