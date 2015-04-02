package kr.ac.jejuuniv;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/mvc-config.xml")
public class HelloPrinterTest {
	
	@Autowired
	HelloPrinter helloPrinter;
	
	@Test
	public void getModel() {
		HelloModel helloModel = helloPrinter.getModel();
		assertEquals("허윤호", helloModel.getName());
		assertEquals("Hello World!!!", helloModel.getHello());
	}
}
