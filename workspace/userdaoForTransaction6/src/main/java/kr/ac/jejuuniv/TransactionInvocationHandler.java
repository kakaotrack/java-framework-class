package kr.ac.jejuuniv;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionInvocationHandler implements InvocationHandler {
	private Object target;
	private String[] patterns;
	private Advice advice;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (isTransactional(method)) {
			MethodInvocation invocation = new MethodInvocation();
			invocation.setMethod(method);
			invocation.setArgs(args);
			invocation.setTarget(target);
			return advice.invoke(invocation);
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

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

}
