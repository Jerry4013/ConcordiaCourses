
public class C4P11_PizzaDemo {

	public static void main(String[] args) {
		C4P11_Pizza pizza1 = new C4P11_Pizza("small", 1, 2, 1);
		System.out.println(pizza1.getDescription());
		C4P11_Pizza pizza2 = new C4P11_Pizza("large", 1, 1, 2);
		System.out.println(pizza2.getDescription());
	}

}
