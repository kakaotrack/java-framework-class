package kr.ac.jejuuniv;

import java.lang.reflect.Method;

public interface Advice {

	Object invoke(MethodInvocatoin invocation) throws Exception;

}
