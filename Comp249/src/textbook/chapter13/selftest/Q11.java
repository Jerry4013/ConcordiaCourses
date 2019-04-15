package textbook.chapter13.selftest;

public class Q11 implements InterfaceA, InterfaceB {
	private int intStuff = 42;

	public static void main(String[] args)
	{
		Q11 object = new Q11();
		System.out.println(object.getStuff()
				+ object.getStuff("Hello"));
	}

	public int getStuff()
	{
		return intStuff;
	}
	public String getStuff(String someStuff)
	{
		return someStuff;
	}
}