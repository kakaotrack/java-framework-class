package kr.ac.jejuuniv;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
public class TransactionAdvice implements MethodInterceptor {
	

	@Autowired
	private PlatformTransactionManager transaction;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object obj;
		obj = null;
		TransactionStatus status = transaction.getTransaction(new DefaultTransactionDefinition());
		try {
			obj = invocation.proceed();
			transaction.commit(status);
		} catch (Exception e) {
			transaction.rollback(status);
			throw e;
		}
		return obj;
	}


}
