package kr.ac.jejuuniv;

import org.junit.Test;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class GenericApplicationContextTest {
	@Test
	public void applicationContext() {
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
		xmlBeanDefinitionReader.loadBeanDefinitions("applicationContext.xml");
		applicationContext.refresh();
		Hello hello = applicationContext.getBean("hello", HelloImpl.class);
		System.out.println(hello.sayHello());
	}

}
