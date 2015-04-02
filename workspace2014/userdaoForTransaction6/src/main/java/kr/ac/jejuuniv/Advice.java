package kr.ac.jejuuniv;

public interface Advice {

	public abstract Object invoke(MethodInvocation invocation) throws Exception;

}