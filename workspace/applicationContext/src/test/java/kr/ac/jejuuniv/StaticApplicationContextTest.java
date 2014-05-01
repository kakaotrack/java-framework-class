package kr.ac.jejuuniv;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

public class StaticApplicationContextTest {
	
	public final static Logger logger = LoggerFactory.getLogger(StaticApplicationContextTest.class);
	
	@Test
	public void testApplicatonContext() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		applicationContext.registerSingleton("hello", HelloImpl.class);
		Hello hello = applicationContext.getBean("hello", Hello.class);
		logger.info(hello.sayHello());
	}
	
	@Test
	public void testApplicationContextUsingBeanDefinition() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		BeanDefinition beanDefinition = new RootBeanDefinition(HelloPrinterImpl.class);
		beanDefinition.getPropertyValues().addPropertyValue("name", "허윤호");
		applicationContext.registerBeanDefinition("helloPrinter", beanDefinition);
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinter.class);
		helloPrinter.print();
	}
	
	@Test
	public void testApplicationContextBeanDefinitionDI() {
		StaticApplicationContext applicationContext = new StaticApplicationContext();
		applicationContext.registerSingleton("hello", HelloImpl.class);
		BeanDefinition beanDefinition = new RootBeanDefinition(HelloPrinterImpl.class);
		beanDefinition.getPropertyValues().addPropertyValue("name", "허윤호");
		beanDefinition.getPropertyValues().addPropertyValue("hello", new RuntimeBeanReference("hello"));
		applicationContext.registerBeanDefinition("helloPrinter", beanDefinition);
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinter.class);
		helloPrinter.sayHelloPrint();
	}
}
