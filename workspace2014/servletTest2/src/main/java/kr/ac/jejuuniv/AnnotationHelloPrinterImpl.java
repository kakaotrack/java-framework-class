package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnnotationHelloPrinterImpl implements HelloPrinter{
	@Value("허윤호")
	private String name;
	@Autowired
	private Hello hello;
	
	public void hello() {
		System.out.println("Hi !!! " + getName());
	}
	
	public void sayHello() {
		System.out.println(getHello().sayHello() + " " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}

	@Override
	public HelloModel getModel() {
		HelloModel helloModel = new HelloModel();
		helloModel.setName(this.name);
		helloModel.setHello(this.hello.sayHello());
		return helloModel;
	}
}
