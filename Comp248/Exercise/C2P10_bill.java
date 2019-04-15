import java.util.Scanner;
public class C2P10_bill {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int i = 1, j=0, quantity=0;
		double subtotal = 0, price = 0, total = 0;
		String[] item = new String[3];
		Double[] totalarray = new Double[3];
		
		while (i<4)
		{
			System.out.println("Input name of item " + i + ":");
			String name = keyboard.nextLine();
			System.out.println("Input quantity of item " + i + ":");
			quantity = keyboard.nextInt();
			System.out.println("Input price of item " + i + ":");
			price = keyboard.nextDouble();
			total = price * quantity;
			subtotal = subtotal + total;
			totalarray[i-1] = total;
			item[i-1] = String.format("%-20s%-10s%-10.2f%-10.2f", name, quantity, price, total);
			keyboard.nextLine();
			System.out.println();
			i = i+1;
		}
		
		System.out.println("\nYour bill:\n");
		System.out.printf("%-20s%-10s%-10s%-10s%n", "Item", "Quantity", "Price", "Total");
		while (j<3)
		{
			System.out.println(item[j]);
			j++;
		}
		System.out.printf("%n%-40s%-10.2f%n","Subtotal", subtotal);
		System.out.printf("%-40s%-10.2f%n","6.25% sales tax", subtotal*0.0625);
		System.out.printf("%-40s%-10.2f%n","Total", subtotal*1.0625);
		
		keyboard.close();
	}

}
