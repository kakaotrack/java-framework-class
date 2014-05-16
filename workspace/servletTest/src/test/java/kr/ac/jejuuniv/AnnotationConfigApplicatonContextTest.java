package kr.ac.jejuuniv;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicatonContextTest {

	@Test
	public void applicationContext() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejuuniv");
		Hello hello = applicationContext.getBean("hello", Hello.class);
		System.out.println(hello.sayHello());
	}
	@Test
	public void applicationContextUsingDI() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejuuniv");
		HelloPrinter helloPrinter = applicationContext.getBean(HelloPrinter.class);
		helloPrinter.sayHello();
	}
}
