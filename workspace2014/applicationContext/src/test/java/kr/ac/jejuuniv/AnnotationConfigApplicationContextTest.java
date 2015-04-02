package kr.ac.jejuuniv;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {
	@Test
	public void testApplicationContext() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejuuniv");
		Hello hello = applicationContext.getBean(Hello.class);
		System.out.println(hello.sayHello());
	}
	
	@Test
	public void testApplicatoinContextDI() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejuuniv");
		HelloPrinter helloPrinter = applicationContext.getBean(HelloPrinter.class);
		helloPrinter.sayHelloPrint();
	}
}
