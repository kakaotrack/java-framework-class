package kr.ac.jejuuniv;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
public class TransactionAspect {
	private static final Logger logger = LoggerFactory.getLogger(TransactionAspect.class);

	private PlatformTransactionManager transactionManager;

	@Around("transactionPointcut()")
//	@Around("execution(* *(..))")
	public Object invoke(ProceedingJoinPoint invocation) throws Throwable  {
		Object object = null;
		TransactionStatus status = getTransactionManager().getTransaction(new DefaultTransactionDefinition());
		try {
			logger.debug("**********************************");
			object = invocation.proceed();
			getTransactionManager().commit(status);
		} catch (Exception e) {
			getTransactionManager().rollback(status);
			throw e;
		}
		return object;
	}
	
	@Pointcut("execution(* kr.ac.jejuuniv..*Dao.add*(..))||execution(* kr.ac.jejuuniv..*Dao.delete*(..))")
	public void transactionPointcut() {}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

}
