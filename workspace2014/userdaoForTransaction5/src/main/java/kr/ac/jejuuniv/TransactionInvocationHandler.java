package kr.ac.jejuuniv;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionInvocationHandler implements InvocationHandler {
	private Object target;
	private String[] patterns;
	private PlatformTransactionManager transactionManager;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (isTransactional(method)) {
			return invokeInTransaction(method, args);
		} else {
			return method.invoke(getTarget(), args);
		}
	}

	private boolean isTransactional(Method method) {
		for(String pattern : getPatterns())
			if(method.getName().startsWith(pattern))
				return true;
		return false;
					
	}

	private Object invokeInTransaction(Method method, Object[] args) throws Exception {
		Object object = null;
		TransactionStatus status = getTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			object = method.invoke(getTarget(), args);
			getTransactionManager().commit(status);
		} catch (Exception e) {
			getTransactionManager().rollback(status);
			throw e;
		}
		return object;
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
