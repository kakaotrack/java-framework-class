package kr.ac.jejuuniv;

public class HelloPrinterImpl implements HelloPrinter{
	private String name;
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
		helloModel.setHello(hello.sayHello());
		return helloModel;
	}
}
