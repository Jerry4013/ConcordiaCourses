package tutorial.tutorial12;

public class Parent {
	public Parent(){
		this.hello();
	}
	
	private void hello(){
		System.out.println("Salute");
	}
}

class Child extends Parent{
	public Child (){
		this.hello();
	}
	
	public void hello(){
		System.out.println("Hey");
	}
}