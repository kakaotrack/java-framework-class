package kr.ac.jejuuniv;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

public class StaticApplicationContextTest {
	@Test
	public void applicationContext() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		applicationContext.registerSingleton("hello", HelloImpl.class);
		Hello hello = applicationContext.getBean("hello", Hello.class);
		System.out.println(hello.sayHello());
	}
	
	@Test
	public void applicationContextUsingBeanDefinition() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		BeanDefinition beanDefinition = new RootBeanDefinition(HelloPrinterImpl.class);
		beanDefinition.getPropertyValues().addPropertyValue("name", "허윤호");
		applicationContext.registerBeanDefinition("helloPrinter", beanDefinition);
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinter.class);
		helloPrinter.hello();

	}
	
	
	@Test
	public void applicationContextUsingDI() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		applicationContext.registerSingleton("hello", HelloImpl.class);
		BeanDefinition beanDefinition = new RootBeanDefinition(HelloPrinterImpl.class);
		beanDefinition.getPropertyValues().addPropertyValue("name", "허윤호");
		beanDefinition.getPropertyValues().addPropertyValue("hello", new RuntimeBeanReference("hello"));
		applicationContext.registerBeanDefinition("helloPrinter", beanDefinition);
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinter.class);
		helloPrinter.sayHello();

	}
	
}
