package textbook.chapter13.test;

public class SomeClass1 {
	
	public class SomeClass2{
		private int m=3;
		
		@Override
		public String toString() {
			return "SomeClass2 [n=" + n + "]";
		}
		
		public void fun3(){
			System.out.println("This is a method of inner Class");
			n=5;
			fun2();
		}
		
		
	}
	
	public static int a;
	private int n=8;
	private static int s=5;
	
	public void display(){
		SomeClass2 s = new SomeClass2();
		System.out.println(s.m);
	}
	
	@Override
	public String toString() {
		return "SomeClass1 [n=" + n + "]";
	}
	
	public void fun1(){
		SomeClass2 sc = new SomeClass2();
		System.out.println(s);
		System.out.println(sc);
		sc.fun3();
	}
	
	public int fun2(){
		SomeClass2 sc = new SomeClass2();
		sc.m=3;
		return a;
	}
	
}
