package kr.ac.jejuuniv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvocation {
	private Method method;
	private Object[] args;
	private Object target;

	public Object proceed() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		return invoke(getMethod(), getArgs());
	}

	public Object invoke(Method method, Object[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		return method.invoke(getTarget(), args);
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
