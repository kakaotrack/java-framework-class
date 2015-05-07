package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloPrinterImpl implements HelloPrinter {
	

	@Value("허윤호")
	private String name;
	
	@Autowired
	private Hello hello;

	public void hi() {
		System.out.println("Hi !!! " + this.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void hello() {
		System.out.println(hello.sayHello() + " " + this.name);
	}

	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}

}
