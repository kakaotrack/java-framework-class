package kr.ac.jejuuniv;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionAdvice implements Advice {
	private PlatformTransactionManager transactionManager;

	@Override
	public Object invoke(MethodInvocation invocation) throws Exception {
		Object object = null;
		TransactionStatus status = getTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			object = invocation.proceed();
			getTransactionManager().commit(status);
		} catch (Exception e) {
			getTransactionManager().rollback(status);
			throw e;
		}
		return object;
	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
}
