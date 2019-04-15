package textbook.two;

import textbook.one.A;



public class D extends A {
	public void demo(){
		v1 = 3;
		v2 = 2;
	}
	
	public void demo2(){
		A a1 = new A();
		a1.v1 = 1;
		C c1 = new C();
		System.out.println(c1);
		
		D object = new D();
		object.v2 = 42;
		
	}
	
	
}
