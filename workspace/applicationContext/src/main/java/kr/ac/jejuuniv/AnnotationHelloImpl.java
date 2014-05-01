package kr.ac.jejuuniv;

import org.springframework.stereotype.Component;

@Component
public class AnnotationHelloImpl implements Hello {

	@Override
	public String sayHello() {
		return "Hello !!!";
	}

}
