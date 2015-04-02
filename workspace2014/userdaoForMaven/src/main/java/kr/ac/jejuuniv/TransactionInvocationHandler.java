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

	private Advice advice;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null;
		if (isTransactional(method)) {

			MethodInvocatoin invocation = new MethodInvocatoin();
			invocation.setTarget(target);
			invocation.setMethod(method);
			invocation.setArgs(args);
			obj = getAdvice().invoke(invocation);
		} else {
			obj = method.invoke(getTarget(), args);
		}
		return obj;
	}

	private boolean isTransactional(Method method) {
		boolean isTransactional = false;
		for (String pattern : getPatterns()) {
			if (method.getName().startsWith(pattern))
				isTransactional = true;
		}
		return isTransactional;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public String[] getPatterns() {
		return patterns;
	}

	public void setPatterns(String[] patterns) {
		this.patterns = patterns;
	}

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

}
