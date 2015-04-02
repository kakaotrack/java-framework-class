package kr.ac.jejuuniv;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionStoreException;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GenericApplicationContextTest {
	@Test
	public void applicationContext() {
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
		reader.loadBeanDefinitions("applicationContext.xml");
		applicationContext.refresh();
		Hello hello = applicationContext.getBean("hello", Hello.class);
		System.out.println(hello.sayHello());
	}
	
	@Test
	public void xmlApplicatonContext() {
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
		HelloPrinter helloPrinter = applicationContext.getBean("helloPrinter", HelloPrinter.class);
		helloPrinter.sayHello();
	}
}
