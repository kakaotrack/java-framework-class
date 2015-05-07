package kr.ac.jejuuniv;

import org.springframework.stereotype.Component;

@Component("hello")
public class HelloImpl implements Hello {

	@Override
	public String sayHello() {
		return "Hello World!!!";
	}

}
