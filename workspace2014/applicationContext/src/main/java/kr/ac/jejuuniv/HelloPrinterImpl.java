package kr.ac.jejuuniv;


public class HelloPrinterImpl implements HelloPrinter {
	
	private String name;
	private Hello hello;

	@Override
	public void print() {
		System.out.println("Hi  !!! " + this.getName());
	}
	
	@Override
	public void sayHelloPrint() {
		System.out.println(getHello().sayHello() + " " + this.getName());
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
