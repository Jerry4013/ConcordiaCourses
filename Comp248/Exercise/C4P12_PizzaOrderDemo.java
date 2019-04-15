
public class C4P12_PizzaOrderDemo {

	public static void main(String[] args) {
		C4P11_Pizza pizza1 = new C4P11_Pizza("large", 1, 0, 1);// Code to create a large pizza, 1 cheese, 1 ham
		C4P11_Pizza pizza2 = new C4P11_Pizza("medium", 2, 2, 0);// Code to create a medium pizza, 2 cheese, 2 pepperoni
		C4P12_PizzaOrder order = new C4P12_PizzaOrder();// Code to create an order
		order.setNumPizzas(2); // 2 pizzas in the order
		order.setPizza1(pizza1); // Set first pizza
		order.setPizza2(pizza2); // Set second pizza
		double total = order.calcTotal(); // Should be 18+20 = 38
		System.out.print(total);
	}

}
