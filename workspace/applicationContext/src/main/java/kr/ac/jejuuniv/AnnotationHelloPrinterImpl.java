package kr.ac.jejuuniv;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class AnnotationHelloPrinterImpl implements HelloPrinter {

	@Value("허윤호")
	private String name;
	
	@Resource
	private Hello hello;

	@Override
	public void print() {
		System.out.println("Hi !!!  " + name);
	}
	
	
	@Override
	public void sayHelloPrint() {
		System.out.println(hello.sayHello() + " " + name);
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
	

}
