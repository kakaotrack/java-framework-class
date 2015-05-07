package kr.ac.jejuuniv;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {
	@Test
	public void applicationContext() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejuuniv");
		Hello hello = applicationContext.getBean("hello", Hello.class);
		System.out.println(hello.sayHello());
	}
	@Test
	public void applicationContextUsingClass() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejuuniv");
		HelloPrinter helloPrinter = applicationContext.getBean(HelloPrinter.class);
		helloPrinter.hi();
	}
	@Test
	public void applicationContextUsingDI() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejuuniv");
		HelloPrinter helloPrinter = applicationContext.getBean(HelloPrinter.class);
		helloPrinter.hello();
	}
}
